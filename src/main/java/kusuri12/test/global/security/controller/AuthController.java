package kusuri12.test.global.security.controller;

import kusuri12.test.global.security.dto.SignInRequest;
import kusuri12.test.global.security.dto.SignUpRequest;
import kusuri12.test.global.security.dto.TokenResponse;
import kusuri12.test.global.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public TokenResponse signIn(@RequestBody SignInRequest request) {
        return authService.signIn(request);
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpRequest request) throws BadRequestException {
        authService.signUp(request);
    }
}