package APP.infrastructure.persistence.mapper;

import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        if (user == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setDocument(user.getDocument());
        entity.setAge(user.getAge());
        entity.setRole(user.getRole() != null ? String.valueOf(user.getRole()) : null);
        entity.setUserName(user.getUserName());
        entity.setPassword(user.getPassword());
        return entity;
    }

    public static APP.domain.model.User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setDocument(entity.getDocument());
        user.setAge(entity.getAge());
        user.setRole(parseRole(entity.getRole()));
        user.setUserName(entity.getUserName());
        user.setPassword(entity.getPassword());
        return user;
    }

    private static Role parseRole(String role) {
        if (role == null) return null;
        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
