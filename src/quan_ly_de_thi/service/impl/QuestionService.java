package quan_ly_de_thi.service.impl;

import quan_ly_de_thi.entity.Question;
import quan_ly_de_thi.repository.impl.QuestionRepository;
import quan_ly_de_thi.service.IQuestionService;

import java.util.List;

public class QuestionService implements IQuestionService {
    private QuestionRepository repository = new QuestionRepository();

    @Override
    public void add(Question question) {
        repository.add(question);
    }

    @Override
    public List<Question> findAll() {
        return repository.findAll();
    }
}
