package APP.adapter.rest.mapper;
 
import org.springframework.stereotype.Component;
import APP.adapter.rest.request.AuthRequest;
import APP.adapter.rest.response.TokenResponseDto;
import APP.domain.model.auth.AuthCredentials;
import APP.domain.model.auth.TokenResponse;
 
 
@Component
public class AuthRestMapper {
    public AuthCredentials toDomain(AuthRequest req) {
        AuthCredentials c = new AuthCredentials();
        c.setUsername(req.getUsername());
        c.setPassword(req.getPassword());
        return c;
    }
 
    public TokenResponseDto toResponse(TokenResponse token) {
        return new TokenResponseDto(token.getToken());
    }
}
