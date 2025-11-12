package APP.infrastructure.persistence.mapper;

import APP.domain.model.Visit;
import APP.infrastructure.persistence.entities.VisitEntity;


public class VisitMapper {

    public static VisitEntity toEntity(Visit visit) {
        if (visit == null) return null;

        VisitEntity entity = new VisitEntity();
        entity.setDocument(visit.getDocument());
        entity.setVisitName(visit.getVisitName());
        entity.setName(UserMapper.toEntity(visit.getName()));
        return entity;
    }

    public static Visit toDomain(VisitEntity entity) {
        if (entity == null) return null;

        Visit visit = new Visit();
        visit.setDocument(entity.getDocument());
        visit.setVisitName(entity.getVisitName());
        visit.setName(UserMapper.toDomain(entity.getName()));
        return visit;
    }
}