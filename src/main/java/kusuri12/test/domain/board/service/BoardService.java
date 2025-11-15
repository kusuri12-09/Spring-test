package kusuri12.test.domain.board.service;

import jakarta.transaction.Transactional;
import kusuri12.test.domain.board.dto.CreateBoardRequest;
import kusuri12.test.domain.board.dto.UpdateBoardRequest;
import kusuri12.test.domain.board.entity.Board;
import kusuri12.test.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("게시글을 찾지 못했습니다.")); // 500 반환, 예외처리는 다음에 배워봅시다
    }

    public Board createBoard(CreateBoardRequest request) {
        String author = (request.getAuthor() == null || request.getAuthor().isBlank())
                ? "anonymous" : request.getAuthor();
        Board board = new Board(request.getTitle(), request.getContent(), author);
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updateBoard(Long id, UpdateBoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("게시글을 찾지 못했습니다.")); // 500

        board.updateBoard(request.getTitle(), request.getContent());
        // 영속 상태, save()를 호출하지 않음
    }

    public List<Board> searchTitle(String query) {
        return boardRepository.findByTitleContains(query);
    }
}
