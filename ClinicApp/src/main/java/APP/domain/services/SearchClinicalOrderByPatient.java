package APP.domain.services;

import java.util.List;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.repository.ClinicalOrderPort;
import APP.domain.repository.PatientPort;

public class SearchClinicalOrderByPatient {

    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;
    
    public List<ClinicalOrder> search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("el paciente no se encuentra registrado");
        }
        return clinicalOrderPort.findByPatient(patient);
    }
    
}
