package kusuri12.test.domain.board.controller;

import kusuri12.test.domain.board.dto.CreateBoardRequest;
import kusuri12.test.domain.board.dto.UpdateBoardRequest;
import kusuri12.test.domain.board.entity.Board;
import kusuri12.test.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/all")
    public List<Board> getAllBoard() {
        return boardService.getAllBoard();
    }

    @GetMapping
    public Board getBoard(@RequestParam Long id) {
        // RequestBody를 사용하지 않음
        return boardService.getBoard(id);
    }

    @PostMapping
    public Board createBoard(@RequestBody CreateBoardRequest request) {
        return boardService.createBoard(request);
    }

    @DeleteMapping
    public void deleteBoard(@RequestParam Long id) {
        // RequestBody를 사용하지 않음
        boardService.deleteBoard(id);
    }

    @PutMapping
    public void updateBoard(@RequestParam Long id, @RequestBody UpdateBoardRequest request) {
        boardService.updateBoard(id, request);
    }

    @GetMapping("/search")
    public List<Board> searchTitle(@RequestParam String query) {
        return boardService.searchTitle(query);
    }
}
