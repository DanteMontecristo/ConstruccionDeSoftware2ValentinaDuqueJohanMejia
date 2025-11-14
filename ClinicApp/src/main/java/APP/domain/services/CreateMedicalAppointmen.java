package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;
import APP.domain.ports.MedicalAppointmentPort;

@Component
public class CreateMedicalAppointmen {

    @Autowired
    private MedicalAppointmentPort medicalAppointmentPort;
    
    public void createMedicalAppointment(MedicalAppointment medicalAppointment) throws Exception {
        Patient patient = medicalAppointmentPort.findByDocument(medicalAppointment);
        if (patient == null) {
            throw new Exception("El usuario no se encuentra registrado");
        }
        medicalAppointmentPort.save(patient);
    }

}