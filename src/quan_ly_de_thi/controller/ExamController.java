package quan_ly_de_thi.controller;

import quan_ly_de_thi.entity.Answer;
import quan_ly_de_thi.entity.Question;
import quan_ly_de_thi.service.IAnswerService;
import quan_ly_de_thi.service.IQuestionService;
import quan_ly_de_thi.service.impl.AnswerService;
import quan_ly_de_thi.service.impl.QuestionService;
import quan_ly_de_thi.view.View;

import java.util.List;
import java.util.Scanner;

public class ExamController {
    private static Scanner scanner = new Scanner(System.in);
    private static IQuestionService questionService = new QuestionService();
    private static IAnswerService answerService = new AnswerService();

    public static void displayMenu() {
        do {
            System.out.println("====================[MENU]=====================");
            System.out.println("1. Thêm mới câu hỏi và đáp án");
            System.out.println("2. Hiển thị danh sách câu hỏi có câu trả lời");
            System.out.println("3. Thoát");
            System.out.println("===============================================");
            System.out.print("Lựa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        display();
                        break;
                    case 3:
                        System.out.println("Tạm biệt");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng số");
            }


        } while (true);

    }

    private static void display() {
        List<Question> questions = questionService.findAll();
        View.displayQuestionList(questions);
    }

    private static void add() {
        Question question = View.inputQuestion();
        List<Answer> answers = View.inputAnswers(question.getId());
        questionService.add(question);
        answerService.add(answers);
        System.out.println("Thêm hành công");
    }

    public static void displayAnswer(String id) {
        List<Answer> answers = answerService.findAnswersByQuestionId(id);
        View.displayAnswerList(answers);
    }
}
