package quan_ly_de_thi.service.impl;

import quan_ly_de_thi.entity.Answer;
import quan_ly_de_thi.repository.IAnswerRepository;
import quan_ly_de_thi.repository.impl.AnswerRepository;
import quan_ly_de_thi.service.IAnswerService;

import java.util.List;

public class AnswerService implements IAnswerService {
    private IAnswerRepository repository = new AnswerRepository();

    @Override
    public void add(List<Answer> answers) {
        repository.add(answers);
    }

    @Override
    public List<Answer> findAnswersByQuestionId(String id) {
        return repository.findAnswersByQuestionId(id);
    }
}
