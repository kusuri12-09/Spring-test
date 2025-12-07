package kusuri12.test.global.security.repository;

import kusuri12.test.global.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByLoginId(String loginId);

    boolean existsByLoginIdIgnoreCase(String loginId);
}
