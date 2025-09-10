package APP.domain.services;

import APP.domain.model.Patient;
import APP.domain.repository.PatientPort;

public class RegisterVisit {

    private PatientPort patientPort;

    public void registerVisit(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) == null) {
            throw new Exception("No existe un paciente registrado con esa cedula");
        }
        patientPort.save(patient);
    }
}
