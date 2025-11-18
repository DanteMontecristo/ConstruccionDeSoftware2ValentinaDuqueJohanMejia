package APP.domain.ports;

import APP.domain.model.MedicalAppointment;
import APP.domain.model.Patient;

public interface MedicalAppointmentPort {

    public Patient findByDocument(MedicalAppointment medicalAppointment) throws Exception;
    public void save(MedicalAppointment medicalAppointment) throws Exception;
}
