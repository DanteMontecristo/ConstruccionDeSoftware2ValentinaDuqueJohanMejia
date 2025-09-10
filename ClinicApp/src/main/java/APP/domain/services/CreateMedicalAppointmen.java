package APP.domain.services;

import APP.domain.model.Patient;
import APP.domain.repository.PatientPort;
import APP.domain.repository.UserPort;
import APP.domain.model.User;

public class CreateMedicalAppointmen {

    private PatientPort patientPort;
    private UserPort userPort;

    public void createMedicalAppointment(User user) throws Exception {
        if (userPort.findByUserName(user) == null) {
            throw new Exception("El usuario no se encuentra registrado");
        }
    }

    public void createMedicalAppointment(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) == null) {
            throw new Exception("El paciente no se encuentra registrado");
        }
        patientPort.save(patient);
    }
}