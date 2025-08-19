import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Welcome to simple 'Math Quiz Game'*****");
        System.out.println("Please answer these five questions");
        MathQuiz quiz = new MathQuiz(scanner);
        int score = quiz.startQuiz();
        System.out.println("Your score is " + score + "/5");
        scanner.close();
    }
}