package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.ClinicalRecordPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

@Component
public class CreateClinicalRecord {

    private static final Logger logger = LoggerFactory.getLogger(CreateClinicalRecord.class);

    @Autowired
    private UserPort userPort;
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;
    
    @Autowired
    private ClinicalRecordPort clinicalRecordPort;

    public void create(ClinicalRecord clinicalRecord) throws Exception {
        logger.info("CreateClinicalRecord: inicio create for clinicalRecord: patientDoc={} doctor={} order={}",
                clinicalRecord != null && clinicalRecord.getName() != null ? clinicalRecord.getName().getDocument() : null,
                clinicalRecord != null && clinicalRecord.getDoctorName() != null ? clinicalRecord.getDoctorName().getDocument() : null,
                clinicalRecord != null && clinicalRecord.getClinicalOrder() != null ? clinicalRecord.getClinicalOrder().getId() : null);
        Patient patient = patientPort.findByDocument(clinicalRecord.getName());
        if(patient==null) {
            logger.warn("CreateClinicalRecord: paciente no encontrado: {}", clinicalRecord!=null?clinicalRecord.getName():null);
            throw new Exception("La historia debe de tener un paciente válido");
        }
        User doctor = userPort.findByDocument(clinicalRecord.getDoctorName());
        if(doctor==null || !doctor.getRole().equals(Role.DOCTOR)) {
            logger.warn("CreateClinicalRecord: doctor inválido o no es role DOCTOR: {}", clinicalRecord!=null?clinicalRecord.getDoctorName():null);
        throw new Exception("la historia clinica debe ser registrada por un veterinario valido");
        }
        // Usar el getter de la instancia en vez del método estático que lanzaba UnsupportedOperationException
        ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(clinicalRecord.getClinicalOrder());
        if(clinicalOrder==null) {
            logger.warn("CreateClinicalRecord: orden clinica no encontrada: {}", clinicalRecord!=null?clinicalRecord.getClinicalOrder():null);
            throw new Exception("La historia debe de tener una orden válida asociada");
        }
        clinicalRecord.setName(patient);
        clinicalRecord.setDoctorName(doctor);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        logger.info("CreateClinicalRecord: guardando clinicalRecord para paciente={} orden={}", patient.getDocument(), clinicalOrder.getId());
        clinicalRecordPort.save(clinicalRecord);
        logger.info("CreateClinicalRecord: guardado exitoso");
}

}
