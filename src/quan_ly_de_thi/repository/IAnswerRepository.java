package quan_ly_de_thi.repository;

import quan_ly_de_thi.entity.Answer;

import java.util.List;

public interface IAnswerRepository {
    void add(List<Answer> answers);

    List<Answer> findAnswersByQuestionId(String questionId);
}
