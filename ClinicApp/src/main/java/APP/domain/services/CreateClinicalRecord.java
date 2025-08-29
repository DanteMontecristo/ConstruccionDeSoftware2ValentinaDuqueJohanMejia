package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.repository.ClinicalOrderPort;
import APP.domain.repository.ClinicalRecordPort;
import APP.domain.repository.PatientPort;
import APP.domain.repository.UserPort;
import APP.domain.model.enums.Role;

public class CreateClinicalRecord {

    private UserPort userPort;
    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;
    private ClinicalRecordPort clinicalRecordPort;

    public void create(ClinicalRecord clinicalRecord) throws Exception {
        Patient patient = patientPort.findByDocument(clinicalRecord.getPatientName());
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
        clinicalRecord.setPatientName(patient);
        clinicalRecord.setDoctorName(doctor);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        clinicalRecordPort.save(clinicalRecord);
}

}
