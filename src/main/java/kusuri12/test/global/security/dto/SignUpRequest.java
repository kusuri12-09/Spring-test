package kusuri12.test.global.security.dto;

public record SignUpRequest(
        String loginId,
        String password,
        String username,
        String email
) { }
