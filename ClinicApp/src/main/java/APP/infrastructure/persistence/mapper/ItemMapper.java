package APP.infrastructure.persistence.mapper;

import APP.domain.model.Item;
import APP.infrastructure.persistence.entities.ItemEntity;

public abstract class ItemMapper {

    protected static void copyToEntity(Item domain, ItemEntity entity) {
        if (domain == null || entity == null) return;

        if (domain.getId() != null) entity.setId(domain.getId());
        entity.setOrderNumber(domain.getOrderNumber());
        entity.setItemNumber(domain.getItemNumber());
        entity.setType(domain.getType());
    }

    protected static void copyToDomain(ItemEntity entity, Item domain) {
        if (entity == null || domain == null) return;

        domain.setId(entity.getId());
        domain.setOrderNumber(entity.getOrderNumber());
        domain.setItemNumber(entity.getItemNumber());
        domain.setType(entity.getType());
    }
}