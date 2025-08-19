import java.util.Scanner;

public class MathQuiz {

    private final Question q = new Question();
    private final Scanner scanner;

    // Constructor: inject Scanner into Question
    public MathQuiz(Scanner scanner){
        this.scanner = scanner;
    }

    // Start the quiz with 5 questions
    public int startQuiz(){
        int score = 0;
        for (int i = 1 ; i <= 5 ; i++){
            Object[] questionElements = q.generateQuestion();
            int num1 = (int) questionElements[0];
            int num2 = (int) questionElements[1];
            char operator = (char) questionElements[2];
            double answer = (double) questionElements[3];

            System.out.printf("%d %c %d = ", num1, operator, num2);
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid number: ");
                scanner.next(); // skip invalid input
            }
            double userInput = scanner.nextDouble();

            boolean correct = q.validateQuestion(userInput, answer);
            if (correct) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + answer);
            }
        }
        return score;
    }

}




