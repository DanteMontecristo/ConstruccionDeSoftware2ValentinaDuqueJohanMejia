package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Invoice;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.InvoicePort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

@Component
public class CreateInvoice {

    private static final Logger logger = LoggerFactory.getLogger(CreateInvoice.class);

    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;
    
    @Autowired
    private InvoicePort invoicePort;
    
    @Autowired
    private UserPort userPort;

    public void createInvoice(Invoice invoice) throws Exception {
        try {
            logger.info("Creando Invoice: pacientDoc={}, medicine={}, order={}", 
                invoice.getDocument(), invoice.isMedicine(), invoice.getOrder() != null ? invoice.getOrder().getId() : "null");
            
            // Buscar y validar paciente
            Patient posiblePatient = new Patient();
            posiblePatient.setDocument(invoice.getDocument());
            Patient patient = patientPort.findByDocument(posiblePatient);
            if (patient == null) {
                logger.warn("Paciente no encontrado para documento: {}", invoice.getDocument());
                throw new Exception("La factura debe tener un paciente asociado");
            }
            
            // Buscar y validar doctor por nombre o username - REQUERIDO
            User doctor = null;
            if (invoice.getDoctorName() != null && invoice.getDoctorName().getName() != null) {
                String doctorIdentifier = invoice.getDoctorName().getName();
                logger.info("Buscando doctor con identificador: {}", doctorIdentifier);
                
                // Intentar buscar por nombre primero (es el campo que recibimos del request)
                doctor = userPort.findByName(doctorIdentifier);
                
                // Si no encuentra por nombre, intentar por username
                if (doctor == null) {
                    logger.info("No encontrado por nombre, intentando por username...");
                    User doctorToSearch = new User();
                    doctorToSearch.setUserName(doctorIdentifier);
                    doctor = userPort.findByUserName(doctorToSearch);
                }
                
                if (doctor == null) {
                    logger.warn("Doctor no encontrado para identificador: {}", doctorIdentifier);
                    throw new Exception("Doctor no encontrado con nombre: " + doctorIdentifier);
                }
                
                logger.info("Doctor encontrado: id={}, name={}, username={}", doctor.getId(), doctor.getName(), doctor.getUserName());
                invoice.setDoctorName(doctor);
            } else {
                throw new Exception("La factura debe tener un doctor asociado");
            }
            
            // Validar y asignar orden clínica si es medicamento
            if (invoice.isMedicine()) {
                if (invoice.getOrder() == null || invoice.getOrder().getId() == 0L) {
                    throw new Exception("El medicamento requiere de una orden clínica asociada");
                }
                ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(invoice.getOrder());
                if (clinicalOrder == null) {
                    throw new Exception("La orden clínica especificada no existe");
                }
                if (patient.getDocument() != clinicalOrder.getName().getDocument()) {
                    throw new Exception("La orden clínica debe pertenecer al paciente");
                }
                invoice.setOrder(clinicalOrder);
                logger.info("Orden clínica asignada: id={}", clinicalOrder.getId());
            }
            
            invoice.setName(patient);
            invoicePort.save(invoice);
            logger.info("Invoice guardado exitosamente: patient={}", patient.getDocument());
        } catch (Exception e) {
            logger.error("Error creando Invoice: {}", e.getMessage(), e);
            throw e;
        }
    }
}
