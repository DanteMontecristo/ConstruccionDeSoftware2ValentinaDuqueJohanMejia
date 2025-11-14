package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;

@Component
public class UpdatePatient {

    @Autowired
    private PatientPort patientPort;

    public void update(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) == null) {
            throw new Exception("No existe un paciente registrado con esa cedula");
        }
        patientPort.save(patient);
    }
}
