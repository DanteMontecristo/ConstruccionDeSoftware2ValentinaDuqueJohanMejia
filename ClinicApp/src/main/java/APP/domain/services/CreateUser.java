package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.User;
import APP.domain.ports.UserPort;

@Component
public class CreateUser {

	@Autowired
	private UserPort userPort;

	public void create(User user) throws Exception {
		if (userPort.findByDocument(user) != null) {
			throw new Exception("Ya existe una persona registrada con esa cedula");
		}

		if (userPort.findByUserName(user) != null) {
			throw new Exception("Ya existe una persona registrada con ese nombre de usuario");
		}
		userPort.save(user);
	}

}