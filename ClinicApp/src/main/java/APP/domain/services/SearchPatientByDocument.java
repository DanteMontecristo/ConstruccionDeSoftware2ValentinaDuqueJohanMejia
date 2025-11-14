package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;

@Component
public class SearchPatientByDocument {

    @Autowired
    private PatientPort patientPort;

    public Patient search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no se encuentra registrado");
        }
        return patientPort.findByDocument(patient);
    }
}
