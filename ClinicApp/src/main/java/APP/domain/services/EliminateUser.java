package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.User;
import APP.domain.ports.UserPort;

@Component
public class EliminateUser {

    @Autowired
    private UserPort userPort;

    public void eliminate(User user) throws Exception {
        if (userPort.findByDocument(user) == null) {
            throw new Exception("No existe una persona registrada con esa cedula");
        }
        userPort.save(user);
    }

}