package quan_ly_de_thi.repository.impl;

import quan_ly_de_thi.common.ReadAndWriteFile;
import quan_ly_de_thi.entity.Answer;
import quan_ly_de_thi.repository.IAnswerRepository;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository implements IAnswerRepository {
    private static final String PATH = "src/quan_ly_de_thi/data/answer.csv";

    @Override
    public void add(List<Answer> answers) {
        List<String> stringList = new ArrayList<>();
        for (Answer answer : answers) {
            stringList.add(answer.toCSVFile());
        }
        ReadAndWriteFile.writeFileCSV(PATH, stringList, true);
    }

    public List<Answer> findAll(){
        List<Answer> answers = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(PATH);
        for (String s : stringList){
            String[] array = s.split("\\s*,\\s*");
            answers.add(new Answer(array[0], array[1], array[2], Boolean.parseBoolean(array[3])));
        }
        return answers;
    }

    @Override
    public List<Answer> findAnswersByQuestionId(String questionId){
        List<Answer> foundAnswers = new ArrayList<>();
        for (Answer answer : findAll()){
            if(answer.getQuestionId().equals(questionId)){
                foundAnswers.add(answer);
            }
        }
        return foundAnswers;
    }
}
