package APP.application.port.in.builder;

import APP.application.port.in.validators.MedicalAppointmentValidator;
import APP.domain.model.MedicalAppointment;

public class MedicalAppointmentBuilder {

    private MedicalAppointmentValidator medicalAppointmentValidator;

    public MedicalAppointment build(String date, String time, String reason, String patientName, String document, String phoneNumber, String email) throws Exception{
        MedicalAppointment medicalAppointment = new MedicalAppointment();
        medicalAppointment.setDate(medicalAppointmentValidator.dateValidator(date));
        medicalAppointment.setTime(medicalAppointmentValidator.timeValidator(time));
        medicalAppointment.setReason(medicalAppointmentValidator.reasonValidator(reason));

        return medicalAppointment;
    }
}
