package APP.infrastructure.persistence.mapper;

import APP.domain.model.MedicalAppointment;
import APP.infrastructure.persistence.entities.MedicalAppointmentEntity;


public class MedicalAppointmentMapper {

    public static MedicalAppointmentEntity toEntity(MedicalAppointment domain) {
        if (domain == null) return null;

        MedicalAppointmentEntity entity = new MedicalAppointmentEntity();
        entity.setDate(domain.getDate());
        entity.setTime(domain.getTime());
        entity.setReason(domain.getReason());
        return entity;
    }

    public static MedicalAppointment toDomain(MedicalAppointmentEntity entity) {
        if (entity == null) return null;

        MedicalAppointment domain = new MedicalAppointment();
        domain.setDate(entity.getDate());
        domain.setTime(entity.getTime());
        domain.setReason(entity.getReason());
        return domain;
    }
}