package quan_ly_de_thi.view;

import quan_ly_de_thi.controller.ExamController;
import quan_ly_de_thi.entity.Answer;
import quan_ly_de_thi.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExamController.displayMenu();
    }

    public static Question inputQuestion() {
        System.out.print("Mã câu hỏi: ");
        String id = scanner.nextLine();
        System.out.print("Nội dung câu hỏi: ");
        String content = scanner.nextLine();
        return new Question(id, content);
    }

    public static List<Answer> inputAnswers(String questionId) {
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.println("===[Đáp án " + i + " ]===");
            System.out.print("Mã câu trả lời: ");
            String id = scanner.nextLine();
            System.out.print("Nội dung câu trả lời: ");
            String content = scanner.nextLine();
            System.out.print("Đáp án đúng hay sai (1 / 0): ");
            int correct = Integer.parseInt(scanner.nextLine());
            answers.add(new Answer(id, questionId, content, (correct == 1) ? true : false));
        }
        return answers;
    }

    public static void displayQuestionList(List<Question> questions) {
        for (Question question : questions){
            System.out.println("Câu hỏi: " + question);
            ExamController.displayAnswer(question.getId());
        }
    }

    public static void displayAnswerList(List<Answer> answers) {
        System.out.println("Câu trả lời: ");
        for (Answer answer : answers){
            System.out.println(answer);
        }
    }
}
