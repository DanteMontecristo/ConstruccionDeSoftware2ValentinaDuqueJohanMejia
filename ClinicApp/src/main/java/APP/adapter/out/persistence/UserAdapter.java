package APP.adapter.out.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import APP.domain.model.User;
import APP.domain.ports.UserPort;
import APP.infrastructure.persistence.entities.UserEntity;
import APP.infrastructure.persistence.mapper.UserMapper;
import APP.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Primary
public class UserAdapter implements UserPort {

    @Autowired
	private UserRepository userRepository;

	@Override
	public User findByDocument(User user) throws Exception {
		UserEntity userEntity = userRepository.findByDocument(user.getDocument());
		return UserMapper.toDomain(userEntity);
	}

	@Override
	public User findByUserName(User user) throws Exception {
		UserEntity userEntity = userRepository.findByUserName(user.getUserName());
		return UserMapper.toDomain(userEntity);
	}

	@Override
	public void save(User user) throws Exception {
		userRepository.save(UserMapper.toEntity(user));
	}
    
}
