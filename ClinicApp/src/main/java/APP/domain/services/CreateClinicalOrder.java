package APP.domain.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

@Component
public class CreateClinicalOrder {
    private static final Logger logger = LoggerFactory.getLogger(CreateClinicalOrder.class);
    
    @Autowired
    private UserPort userPort;
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public void create(ClinicalOrder clinicalOrder) throws Exception {
        try {
            logger.info("Creando ClinicalOrder: doctorDoc={}, patientDoc={}, medicine={}",
                    clinicalOrder.getDoctorName() != null ? clinicalOrder.getDoctorName().getDocument() : "null",
                    clinicalOrder.getDocument(), clinicalOrder.getMedicine());

            User doctor = userPort.findByDocument(clinicalOrder.getDoctorName());
            if (doctor == null || doctor.getRole() == null || !doctor.getRole().equals(Role.DOCTOR)) {
                logger.warn("Usuario doctor no válido o no encontrado: {}", clinicalOrder.getDoctorName());
                throw new Exception("Las ordenes solo la puede crear un doctor");
            }

            Patient posiblePatient = new Patient();
            posiblePatient.setDocument(clinicalOrder.getDocument());
            Patient patient = patientPort.findByDocument(posiblePatient);
            if (patient == null) {
                logger.warn("Paciente no encontrado para documento: {}", clinicalOrder.getDocument());
                throw new Exception("Las ordenes se deben de aplicar a pacientes registrados");
            }

            clinicalOrder.setName(patient);
            clinicalOrder.setDoctorName(doctor);
            clinicalOrderPort.save(clinicalOrder);
            logger.info("ClinicalOrder guardada (patient={}, doctor={})", patient.getDocument(), doctor.getDocument());
        } catch (Exception e) {
            logger.error("Error creando ClinicalOrder: {}", e.getMessage(), e);
            throw e;
        }
    }

    public List<ClinicalOrder> search(Patient patient) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
}
