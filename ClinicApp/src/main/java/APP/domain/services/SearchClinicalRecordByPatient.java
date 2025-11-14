package APP.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalRecordPort;
import APP.domain.ports.PatientPort;

@Component
public class SearchClinicalRecordByPatient {
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalRecordPort clinicalRecordPort;
    
    public List<ClinicalRecord> search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("No existe el paciente buscado");
        }
        return clinicalRecordPort.findByPatient(patient);
    }
    
}
