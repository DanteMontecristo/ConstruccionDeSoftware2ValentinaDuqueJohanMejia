package APP.domain.services;

import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;
import APP.domain.repository.MedicalAppointmentPort;

public class CreateMedicalAppointmen {

    private MedicalAppointmentPort medicalAppointmentPort;
    private Patient patient;

    public void createMedicalAppointment(MedicalAppointment medicalAppointment) throws Exception {
        if (medicalAppointmentPort.findByDocument(medicalAppointment) == null) {
            throw new Exception("El usuario no se encuentra registrado");
        }
        medicalAppointmentPort.save(patient);
    }

}