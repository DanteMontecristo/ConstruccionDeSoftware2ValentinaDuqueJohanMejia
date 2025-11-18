package APP.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import APP.domain.ports.UserPort;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.infrastructure.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private UserPort userPort;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            logger.info("📊 ===== ESTADO DE LA BD AL INICIAR =====");
            
            // Listar todos los usuarios
            var allUsers = userRepository.findAll();
            logger.info("📋 Total de usuarios en BD: {}", allUsers.size());
            allUsers.forEach(u -> logger.info("   - ID: {}, username: '{}', password: '{}', role: {}", 
                u.getId(), u.getUserName(), u.getPassword(), u.getRole()));
            
            logger.info("📊 ===== FIN DE LISTADO =====\n");
            
            User u = new User();
            u.setUserName("admin");
            u.setPassword("admin");
            u.setName("Administrator");
            u.setDocument(123456789L);
            u.setAge(30);
            u.setRole(Role.RRHH);

            if (userPort.findByUserName(u) == null) {
                userPort.save(u);
                logger.info("✅ Usuario admin creado: admin / admin");
            } else {
                logger.info("✅ Usuario admin ya existe");
            }
        } catch (Exception ex) {
            logger.error("❌ Error al inicializar datos: {}", ex.getMessage(), ex);
        }
    }
}
