package kusuri12.test.domain.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(length = 1024)
    private String content;

    // 객체 초기화할 때 사용, setter를 사용하지 않는 이유는 찾아보기
    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
