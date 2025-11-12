package APP.adapter.in.builder;

import APP.adapter.in.validators.MedicalAppointmentValidator;
import APP.domain.model.MedicalAppointment;

public class MedicalAppointmentBuilder {

    private MedicalAppointmentValidator medicalAppointmentValidator;

    public MedicalAppointment build(String date, String time, String reason, String patientName, String doctorName) throws Exception{
        MedicalAppointment medicalAppointment = new MedicalAppointment();
        medicalAppointment.setDate(medicalAppointmentValidator.dateValidator(date));
        medicalAppointment.setTime(medicalAppointmentValidator.timeValidator(time));
        medicalAppointment.setReason(medicalAppointmentValidator.reasonValidator(reason));
        medicalAppointment.setPatientName(medicalAppointmentValidator.patientNameValidator(patientName));
        medicalAppointment.setDoctorName(medicalAppointmentValidator.doctorNameValidator(doctorName));

        return medicalAppointment;
    }
}
