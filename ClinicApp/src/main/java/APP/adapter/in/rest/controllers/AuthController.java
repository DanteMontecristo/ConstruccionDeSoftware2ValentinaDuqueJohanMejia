package APP.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import APP.adapter.rest.mapper.AuthRestMapper;
import APP.adapter.rest.request.AuthRequest;
import APP.adapter.rest.response.TokenResponseDto;
import APP.application.usecase.LoginUseCase;
import APP.domain.model.auth.AuthCredentials;
import APP.domain.model.auth.TokenResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private AuthRestMapper authRestMapper;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody AuthRequest request) throws Exception {
        AuthCredentials credentials = authRestMapper.toDomain(request);
        TokenResponse token = loginUseCase.login(credentials);
        return ResponseEntity.ok(authRestMapper.toResponse(token));
    }
}
