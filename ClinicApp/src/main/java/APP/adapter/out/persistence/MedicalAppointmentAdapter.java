package APP.adapter.out.persistence;

import org.springframework.stereotype.Service;
import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;
import APP.domain.ports.MedicalAppointmentPort;

@Service
public class MedicalAppointmentAdapter implements MedicalAppointmentPort {

    @Override
    public Patient findByDocument(MedicalAppointment medicalAppointment) throws Exception {
        // TODO: Implement logic to find by document
        return null;
    }

    @Override
    public void save(Patient patient) throws Exception {
        // TODO: Implement save logic
        System.out.println("Se ha guardado la cita medica");
    }
}
