package APP.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.PatientPort;

@Component
public class SearchClinicalOrderByPatient {

    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;
    
    public List<ClinicalOrder> search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("el paciente no se encuentra registrado");
        }
        return clinicalOrderPort.findByPatient(patient);
    }
    
}
