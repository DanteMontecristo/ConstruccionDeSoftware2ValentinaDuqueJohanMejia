package APP.domain.services;

import APP.domain.model.User;
import APP.domain.repository.UserPort;

public class CreateUser {

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