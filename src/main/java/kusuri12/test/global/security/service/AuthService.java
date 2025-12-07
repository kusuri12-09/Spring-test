package kusuri12.test.global.security.service;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import kusuri12.test.global.security.dto.SignInRequest;
import kusuri12.test.global.security.dto.SignUpRequest;
import kusuri12.test.global.security.dto.TokenResponse;
import kusuri12.test.global.security.entity.User;
import kusuri12.test.global.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private static final String privateKey = "안녕하세요";

    private static final SecretKey key = Keys.hmacShaKeyFor(privateKey.getBytes(StandardCharsets.UTF_8));
    private static final JwtParser parser = Jwts.parser().verifyWith(key).build();

    public TokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new NullPointerException("아이디를 찾을 수 없습니다."));

        if (encoder.matches(user.getPassword(), request.password())) {
            String token = Jwts.builder()
                    .id(user.getId().toString())
                    .subject("user")
                    .claim("username", user.getUsername())
                    .issuedAt(Date.from(Instant.now()))
                    .expiration(Date.from(Instant.now().plusSeconds(3600)))
                    .signWith(key)
                    .compact();

            return new TokenResponse(token);
        }

        throw new NullPointerException();
    }

    @Transactional
    public void signUp(SignUpRequest request) throws BadRequestException {
        if (userRepository.existsByLoginIdIgnoreCase(request.loginId())) {
            throw new BadRequestException("이미 있는 아이디입니다.");
        }

        userRepository.save(new User(request.loginId(), encoder.encode(request.password()), request.username(), request.email()));
    }
}
