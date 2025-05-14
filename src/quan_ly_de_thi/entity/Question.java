package quan_ly_de_thi.entity;

public class Question {
    private String id;
    private String content;

    public Question(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toCSVFile(){
        return id + "," + content;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
