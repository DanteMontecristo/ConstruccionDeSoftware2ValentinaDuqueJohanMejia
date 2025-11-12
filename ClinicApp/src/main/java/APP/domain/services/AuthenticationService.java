package APP.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import APP.application.exception.BusinessException;
import APP.domain.model.User;
import APP.domain.model.auth.AuthCredentials;
import APP.domain.model.auth.TokenResponse;
import APP.domain.ports.AuthenticationPort;
import APP.domain.ports.UserPort;

@Service
public class AuthenticationService {
    
    @Autowired
    private AuthenticationPort authenticationPort;
    
    @Autowired
    private UserPort userPort;
    
    public TokenResponse authenticate(AuthCredentials credentials) throws Exception{
        User user = this.getUserByUsername(credentials.getUsername());
        this.validatePassword(credentials.getPassword(), user.getPassword());
        return authenticationPort.authenticate(credentials, String.valueOf(user.getRole()));
    }

    private User getUserByUsername(String username)  throws Exception{
    	User user = new User();
    	user.setUserName(username);
        user = userPort.findByUserName(user);
        if (user == null) {
            throw new BusinessException("Usuario no encontrado");
        }
        return user;
    }

    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        if (!inputPassword.equals(storedPassword)) {
            throw new BusinessException("Contraseña incorrecta");
        }
    }
}
