package APP.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import APP.adapter.in.builder.UserBuilder;
import APP.adapter.rest.request.CreateUserRequest;
import APP.adapter.rest.response.UserResponse;
import APP.domain.model.User;

@Component
public class UserRestMapper {

    @Autowired
    private UserBuilder userBuilder;

    public User toDomain(CreateUserRequest req) throws Exception {
        return userBuilder.build(
            req.getName(),
            req.getDocument(),
            req.getAge(),
            req.getUserName(),
            req.getPassword(),
            req.getAddress(),
            req.getRole(),
            req.getEmail(),
            req.getPhoneNumber()
        );
    }

    public UserResponse toResponse(User user) {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setDocument(user.getDocument());
        res.setAge(user.getAge());
        res.setUserName(user.getUserName());
        res.setRole(user.getRole() != null ? String.valueOf(user.getRole()) : null);
        return res;
    }
}
