package APP.infrastructure.persistence.mapper;

import APP.domain.model.Visit;
import APP.infrastructure.persistence.entities.VisitEntity;


public class VisitMapper {

    public static VisitEntity toEntity(Visit visit) {
        if (visit == null) return null;

        VisitEntity entity = new VisitEntity();
        entity.setDocument(visit.getDocument());
        entity.setVisitName(visit.getVisitName());
        // Solo mapear el user si existe en el dominio
        if (visit.getName() != null) {
            entity.setName(UserMapper.toEntity(visit.getName()));
        } else {
            entity.setName(null);
        }
        return entity;
    }

    public static Visit toDomain(VisitEntity entity) {
        if (entity == null) return null;

        Visit visit = new Visit();
        visit.setDocument(entity.getDocument());
        visit.setVisitName(entity.getVisitName());
        // Solo mapear si existe en la entidad
        if (entity.getName() != null) {
            visit.setName(UserMapper.toDomain(entity.getName()));
        } else {
            visit.setName(null);
        }
        return visit;
    }
}