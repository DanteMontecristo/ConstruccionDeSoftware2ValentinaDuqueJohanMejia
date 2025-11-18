package APP.adapter.out.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import APP.domain.model.User;
import APP.domain.ports.UserPort;
import APP.infrastructure.persistence.entities.UserEntity;
import APP.infrastructure.persistence.mapper.UserMapper;
import APP.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Primary
public class UserAdapter implements UserPort {

    private static final Logger logger = LoggerFactory.getLogger(UserAdapter.class);

    @Autowired
	private UserRepository userRepository;

	@Override
	public User findByDocument(User user) throws Exception {
		UserEntity userEntity = userRepository.findByDocument(user.getDocument());
		return UserMapper.toDomain(userEntity);
	}

	@Override
	public User findByUserName(User user) throws Exception {
		logger.info("🔍 Buscando usuario con username: '{}'", user.getUserName());
		
		// Intentar búsqueda exacta primero
		UserEntity userEntity = userRepository.findByUserName(user.getUserName());
		logger.info("📊 Búsqueda exacta result: {}", userEntity != null ? "ENCONTRADO" : "NO ENCONTRADO");
		
		if (userEntity == null) {
			logger.info("🔄 Intentando búsqueda case-insensitive...");
			userEntity = userRepository.findByUserNameIgnoreCase(user.getUserName());
			logger.info("📊 Búsqueda case-insensitive result: {}", userEntity != null ? "ENCONTRADO" : "NO ENCONTRADO");
		}
		
		if (userEntity != null) {
			logger.info("✅ Usuario encontrado: id={}, username={}, role={}", 
				userEntity.getId(), userEntity.getUserName(), userEntity.getRole());
		} else {
			logger.warn("❌ Usuario NO encontrado en BD");
		}
		
		return UserMapper.toDomain(userEntity);
	}

	@Override
	public User findByName(String name) throws Exception {
		logger.info("🔍 Buscando usuario por nombre: '{}'", name);
		
		// Intentar búsqueda exacta primero
		UserEntity userEntity = userRepository.findByName(name);
		logger.info("📊 Búsqueda exacta result: {}", userEntity != null ? "ENCONTRADO" : "NO ENCONTRADO");
		
		if (userEntity == null) {
			logger.info("🔄 Intentando búsqueda case-insensitive...");
			userEntity = userRepository.findByNameIgnoreCase(name);
			logger.info("📊 Búsqueda case-insensitive result: {}", userEntity != null ? "ENCONTRADO" : "NO ENCONTRADO");
		}
		
		if (userEntity != null) {
			logger.info("✅ Usuario encontrado por nombre: id={}, name={}, username={}", 
				userEntity.getId(), userEntity.getName(), userEntity.getUserName());
		} else {
			logger.warn("❌ Usuario NO encontrado con nombre: {}", name);
		}
		
		return UserMapper.toDomain(userEntity);
	}

	@Override
	public void save(User user) throws Exception {
		logger.info("💾 Guardando usuario: username={}, role={}", user.getUserName(), user.getRole());
		userRepository.save(UserMapper.toEntity(user));
		logger.info("✅ Usuario guardado exitosamente");
	}
    
}
