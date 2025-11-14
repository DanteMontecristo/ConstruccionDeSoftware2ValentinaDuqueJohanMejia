package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    private UserPort userPort;
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;
    
    @Autowired
    private ClinicalRecordPort clinicalRecordPort;

    public void create(ClinicalRecord clinicalRecord) throws Exception {
        Patient patient = patientPort.findByDocument(clinicalRecord.getName());
        if(patient==null) {
            throw new Exception("La historia debe de tener un paciente válido");
        }
        User doctor = userPort.findByDocument(clinicalRecord.getDoctorName());
        if(doctor==null || !doctor.getRole().equals(Role.DOCTOR)) {
        throw new Exception("la historia clinica debe ser registrada por un veterinario valido");
        }
        ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(ClinicalRecord.getclinicalOrder());
        if(clinicalOrder==null) {
            throw new Exception("La historia debe de tener una orden válida asociada");
        }
        clinicalRecord.setName(patient);
        clinicalRecord.setDoctorName(doctor);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        clinicalRecordPort.save(clinicalRecord);
}

}
