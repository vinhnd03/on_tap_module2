package quan_ly_de_thi.service;

import quan_ly_de_thi.entity.Answer;

import java.util.List;

public interface IAnswerService {
    void add(List<Answer> answers);

    List<Answer> findAnswersByQuestionId(String id);
}
