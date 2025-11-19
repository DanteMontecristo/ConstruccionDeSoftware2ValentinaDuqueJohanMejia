package APP.adapter.out.persistence;

import org.springframework.stereotype.Component;
import APP.domain.model.User;
import APP.domain.ports.UserPort;

@Component
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

	@Override
	public User findByName(String name) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteByDocument(long document) throws Exception {
		throw new UnsupportedOperationException();
	}

}
