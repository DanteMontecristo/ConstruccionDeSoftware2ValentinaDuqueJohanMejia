package APP.infrastructure.persistence.mapper;

import APP.domain.model.MedicalItem;
import APP.infrastructure.persistence.entities.MedicalItemEntity;

public class MedicalItemMapper {

    public static MedicalItemEntity toEntity(MedicalItem domain) {
        if (domain == null) return null;

        MedicalItemEntity entity = new MedicalItemEntity();
        entity.setMedicineName(domain.getMedicineName());
        entity.setDose(domain.getDose());
        entity.setTreatamentDuration(domain.getTreatamentDuration());
        entity.setCost(domain.getCost());
        return entity;
    }

    public static MedicalItem toDomain(MedicalItemEntity entity) {
        if (entity == null) return null;

        MedicalItem domain = new MedicalItem();
        domain.setMedicineName(entity.getMedicineName());
        domain.setDose(entity.getDose());
        domain.setTreatamentDuration(entity.getTreatamentDuration());
        domain.setCost(entity.getCost());
        return domain;
    }
}