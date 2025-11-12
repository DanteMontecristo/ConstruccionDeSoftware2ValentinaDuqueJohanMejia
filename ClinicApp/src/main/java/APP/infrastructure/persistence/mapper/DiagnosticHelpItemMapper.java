package APP.infrastructure.persistence.mapper;

import APP.domain.model.DiagnosticHelpItem;
import APP.infrastructure.persistence.entities.DiagnosticHelpItemEntity;

public class DiagnosticHelpItemMapper extends ItemMapper {

    public static DiagnosticHelpItemEntity toEntity(DiagnosticHelpItem domain) {
        if (domain == null) return null;

        DiagnosticHelpItemEntity entity = new DiagnosticHelpItemEntity();

        // Copiar campos de Item
        copyToEntity(domain, entity);

        // Campos específicos de DiagnosticHelpItem
        entity.setDetail(domain.getDetail());
        entity.setAmount(domain.getAmount());
        entity.setCost(domain.getCost());
        entity.setSpecialist(domain.isSpecialist());

        return entity;
    }

    public static DiagnosticHelpItem toDomain(DiagnosticHelpItemEntity entity) {
        if (entity == null) return null;

        DiagnosticHelpItem domain = new DiagnosticHelpItem();

        // Copiar campos de Item
        copyToDomain(entity, domain);

        // Campos específicos de DiagnosticHelpItem
        domain.setDetail(entity.getDetail());
        domain.setAmount(entity.getAmount());
        domain.setCost(entity.getCost());
        domain.setSpecialist(entity.isSpecialist());

        return domain;
    }
}