package APP.domain.services;

import APP.domain.model.User;
import APP.domain.ports.UserPort;

public class EliminateUser {

    private UserPort userPort;

    public void eliminate(User user) throws Exception {
        if (userPort.findByDocument(user) == null) {
            throw new Exception("No existe una persona registrada con esa cedula");
        }
        userPort.save(user);
    }

}