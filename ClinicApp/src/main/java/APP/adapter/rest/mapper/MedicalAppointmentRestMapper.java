package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.adapter.in.builder.MedicalAppointmentBuilder;
import APP.adapter.rest.request.MedicalAppointmentRequest;
import APP.adapter.rest.response.MedicalAppointmentResponse;
import APP.domain.model.MedicalAppointment;

@Component
public class MedicalAppointmentRestMapper {

    @Autowired
    private MedicalAppointmentBuilder medicalAppointmentBuilder;

    public MedicalAppointment toDomain(MedicalAppointmentRequest req) throws Exception {
        return medicalAppointmentBuilder.build(
            req.getDate(),
            req.getTime(), 
            req.getReason(),
            req.getPatientName(),
            req.getDoctorName()
        );
    }

    public MedicalAppointmentResponse toResponse(MedicalAppointment medicalAppointment) {
        MedicalAppointmentResponse res = new MedicalAppointmentResponse();
        res.setDate(medicalAppointment.getDate());
        res.setTime(medicalAppointment.getTime());
        res.setReason(medicalAppointment.getReason());
        res.setPatientName(medicalAppointment.getPatientName());
        res.setDoctorName(medicalAppointment.getDoctorName());
        return res;
    }
}
