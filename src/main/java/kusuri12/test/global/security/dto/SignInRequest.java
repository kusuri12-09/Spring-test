package kusuri12.test.global.security.dto;

public record SignInRequest(
        String loginId,
        String password
) {}
