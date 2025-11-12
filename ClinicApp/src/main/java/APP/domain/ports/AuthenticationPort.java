package APP.domain.ports;

import APP.domain.model.auth.AuthCredentials;
import APP.domain.model.auth.TokenResponse;

public interface AuthenticationPort {

    TokenResponse authenticate(AuthCredentials credentials, String role);
    boolean validateToken(String token);
    String extractUsername(String token);
    String extractRole(String token);

}
