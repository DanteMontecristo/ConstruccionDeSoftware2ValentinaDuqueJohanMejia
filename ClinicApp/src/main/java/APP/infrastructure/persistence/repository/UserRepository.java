package APP.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import APP.infrastructure.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByDocument(long document);

	public UserEntity findByUserName(String userName);

	// Busca username sin distinguir mayúsculas/minúsculas
	public UserEntity findByUserNameIgnoreCase(String userName);

	// Busca por nombre (name field)
	public UserEntity findByName(String name);

	// Busca por nombre sin distinguir mayúsculas/minúsculas
	public UserEntity findByNameIgnoreCase(String name);

}
