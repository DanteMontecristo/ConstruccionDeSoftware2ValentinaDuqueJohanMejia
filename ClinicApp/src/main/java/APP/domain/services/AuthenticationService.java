package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.application.exception.BusinessException;
import APP.domain.model.User;
import APP.domain.model.auth.AuthCredentials;
import APP.domain.model.auth.TokenResponse;
import APP.domain.ports.AuthenticationPort;
import APP.domain.ports.UserPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationService {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    
    @Autowired
    private AuthenticationPort authenticationPort;
    
    @Autowired
    private UserPort userPort;
    
    public TokenResponse authenticate(AuthCredentials credentials) throws Exception{
        logger.info("🔐 Iniciando autenticación para usuario: '{}'", credentials.getUsername());
        User user = this.getUserByUsername(credentials.getUsername());
        logger.info("✅ Usuario encontrado, validando contraseña...");
        this.validatePassword(credentials.getPassword(), user.getPassword());
        logger.info("✅ Contraseña válida, generando token...");
        return authenticationPort.authenticate(credentials, String.valueOf(user.getRole()));
    }

    private User getUserByUsername(String username)  throws Exception{
        logger.info("🔎 getUserByUsername() llamado con: '{}'", username);
    	User user = new User();
    	user.setUserName(username);
        logger.info("📤 Llamando userPort.findByUserName()...");
        user = userPort.findByUserName(user);
        if (user == null) {
            logger.error("❌ Usuario no encontrado: '{}'", username);
            throw new BusinessException("Usuario no encontrado");
        }
        logger.info("✅ Usuario encontrado desde BD: {}", user.getUserName());
        return user;
    }

    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        logger.info("🔑 Validando contraseña...");
        if (!inputPassword.equals(storedPassword)) {
            logger.error("❌ Contraseña incorrecta");
            throw new BusinessException("Contraseña incorrecta");
        }
        logger.info("✅ Contraseña correcta");
    }
}
