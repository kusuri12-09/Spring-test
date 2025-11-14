package kusuri12.test.domain.board.service;

import kusuri12.test.domain.board.dto.CreateBoardRequest;
import kusuri12.test.domain.board.dto.UpdateBoardRequest;
import kusuri12.test.domain.board.entity.Board;
import kusuri12.test.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board getBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("게시글을 찾지 못했습니다.")); // 500 반환, 예외처리는 다음에 배워봅시다
    }

    public Board createBoard(CreateBoardRequest request) {
        Board board = new Board();
        board.updateBoard(request.getTitle(), request.getContent());
        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public void updateBoard(Long id, UpdateBoardRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("게시글을 찾지 못했습니다.")); // 500
        board.updateBoard(request.getTitle(), request.getContent());
        boardRepository.save(board);
    }
}
