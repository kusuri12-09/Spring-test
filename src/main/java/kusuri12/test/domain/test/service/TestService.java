package kusuri12.test.domain.test.service;

import kusuri12.test.domain.test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;

    public List<String> getAll() {
        return testRepository.getAll();
    }

    public String getMemo(int id) {
        return testRepository.get(id);
    }

    public void deleteMemo(int id) {
        testRepository.remove(id);
    }

    public void createMemo(String memo) {
        testRepository.add(memo);
    }

    public void editMemo(int id, String memo) {
        testRepository.set(id, memo);
    }
}
