package kusuri12.test.domain.test.controller;

import kusuri12.test.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/all")
    public List<String> getAll() {
        return testService.getAll();
    }

    @GetMapping("/memo")
    public String getMemo(@RequestParam("id") int id) {
        return testService.getMemo(id);
    }

    @GetMapping("/delete")
    public String deleteMemo(@RequestParam("id") int id) {
        testService.deleteMemo(id);
        return "success";
    }

    @GetMapping("/create")
    public String createMemo(@RequestParam("memo") String memo) {
        testService.createMemo(memo);
        return "success";
    }

    @GetMapping("/edit")
    public String editMemo(@RequestParam("id") int id, @RequestParam("memo") String memo) {
        testService.editMemo(id, memo);
        return "success";
    }
}
