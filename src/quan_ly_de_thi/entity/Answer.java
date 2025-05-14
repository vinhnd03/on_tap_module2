package quan_ly_de_thi.entity;

public class Answer {
    private String id;
    private String questionId;
    private String content;

    private boolean correct;

    public Answer(String id, String questionId, String content, boolean correct) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.correct = correct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toCSVFile() {
        return id + "," + questionId + "," + content + "," + correct;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", content='" + content + '\'' +
                ", correct='" + correct + '\'' +
                '}';
    }
}
