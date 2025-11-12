package APP.domain.services;

import APP.domain.model.User;
import APP.domain.ports.UserPort;

public class UpdateUser {

    private UserPort userPort;

    public void update(User user) throws Exception {

        if (userPort.findByDocument(user) == null) {
            throw new Exception("No existe una persona registrada con esa cedula");
        }

        if (userPort.findByUserName(user) == null) {
            throw new Exception("El nombre de usuario no esta registrado");
        }
        userPort.save(user);
    }
}
