package kusuri12.test.global.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column
    private String username;

    @Column(unique = true)
    private String email;

    public User(String loginId, String password, String username, String email) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public void updateUser(String loginId, String password, String username, String email) {
        this.loginId = loginId;
        this.password = password;
        this.username = username;
        this.email = email;
    }
}
