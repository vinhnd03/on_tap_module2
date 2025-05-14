package quan_ly_de_thi.repository.impl;

import quan_ly_de_thi.common.ReadAndWriteFile;
import quan_ly_de_thi.entity.Question;
import quan_ly_de_thi.repository.IQuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements IQuestionRepository {
    private static final String PATH = "src/quan_ly_de_thi/data/question.csv";

    @Override
    public void add(Question question) {
        List<String> stringList = new ArrayList<>();
        stringList.add(question.toCSVFile());
        ReadAndWriteFile.writeFileCSV(PATH, stringList, true);
    }

    public List<Question> findAll(){
        List<Question> questions = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(PATH);
        for(String s : stringList){
            String[] array = s.split("\\s*,\\s*");
            questions.add(new Question(array[0], array[1]));
        }
        return questions;
    }
}
