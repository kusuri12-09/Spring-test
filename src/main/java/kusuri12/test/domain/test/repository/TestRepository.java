package kusuri12.test.domain.test.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRepository {
    private List<String> memo = new ArrayList<>();

    public List<String> getAll() {
        return memo;
    }

    public String get(int id) {
        return memo.get(id);
    }

    public void remove(int id) {
        this.memo.remove(id);
    }

    public void add(String memo) {
        this.memo.add(memo);
    }

    public void set(int id, String memo) {
        this.memo.set(id, memo);
    }
}
