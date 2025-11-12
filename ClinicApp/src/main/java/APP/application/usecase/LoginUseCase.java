package APP.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import APP.domain.model.auth.AuthCredentials;
import APP.domain.model.auth.TokenResponse;
import APP.domain.services.AuthenticationService;

@Component
public class LoginUseCase {

    @Autowired
    private AuthenticationService authenticationService;

    public TokenResponse login(AuthCredentials credentials) throws Exception {
        return authenticationService.authenticate(credentials);
    }
}
