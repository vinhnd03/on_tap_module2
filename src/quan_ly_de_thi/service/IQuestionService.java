package quan_ly_de_thi.service;

import quan_ly_de_thi.entity.Question;

import java.util.List;

public interface IQuestionService {
    void add(Question question);

    List<Question> findAll();
}
