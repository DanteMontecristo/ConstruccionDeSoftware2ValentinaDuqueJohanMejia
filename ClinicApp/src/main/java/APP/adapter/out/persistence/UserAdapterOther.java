package APP.adapter.out.persistence;

import APP.domain.model.User;
import APP.domain.ports.UserPort;

public class UserAdapterOther implements UserPort {

    @Override
	public User findByDocument(User user) throws Exception {
		return null;
	}

	@Override
	public User findByUserName(User user) throws Exception {
		return null;
	}

	@Override
	public void save(User user) throws Exception {
	}

}
