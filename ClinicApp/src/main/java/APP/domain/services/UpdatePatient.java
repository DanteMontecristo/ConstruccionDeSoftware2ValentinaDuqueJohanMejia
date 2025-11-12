package APP.domain.services;

import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;

public class UpdatePatient {

    private PatientPort patientPort;

    public void update(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) == null) {
            throw new Exception("No existe un paciente registrado con esa cedula");
        }
        patientPort.save(patient);
    }
}
