package APP.domain.services;

import java.util.List;

import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalRecordPort;
import APP.domain.ports.PatientPort;

public class SearchClinicalRecordByPatient {
    
    private PatientPort patientPort;
    private ClinicalRecordPort clinicalRecordPort;
    
    public List<ClinicalRecord> search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("No existe el paciente buscado");
        }
        return clinicalRecordPort.findByPatient(patient);
    }
    
}
