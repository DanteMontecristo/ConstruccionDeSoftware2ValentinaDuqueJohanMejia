package APP.domain.services;

import APP.domain.repository.PatientPort;
import APP.domain.model.Patient;

public class SearchPatientByDocument {

    private PatientPort patientPort;

    public Patient search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("El paciente no se encuentra registrado");
        }
        return patientPort.findByDocument(patient);
    }
}
