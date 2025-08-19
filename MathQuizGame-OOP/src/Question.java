import java.util.Random;
import java.util.Scanner;

public class Question {
    private final Scanner scanner;
    public Question(Scanner scanner){
        this.scanner = scanner;
    }

    private static final char[] operators = {'+', '-' , '*', '/'};

    private final Random num = new Random();

    // create a random question
    private Object[] generateQuestion(){
        int num1 = num.nextInt(1000);
        int num2;
        do{
            num2 = num.nextInt(1000);
        } while (num2 == 0);

        int operatorIndex = num.nextInt(4);
        char operator = operators[operatorIndex];

        // calculate answer
        double answer = switch (operator){
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> Math.round(((double)num1 / (double) num2) * 100.0) / 100.0;
            default -> 0;
        };
        return new Object[] {num1, num2, operator, answer};
    }
    // ask question and check answer
    public boolean question(){
        Object[] questionElements = generateQuestion();
        double answer = (double) questionElements[3];

        System.out.printf("%d %c %d = ", (int) questionElements[0], (char) questionElements[2], (int) questionElements[1]);
        double userInput = scanner.nextDouble();

        // tolerance
        double epsilon = 1e-2;
        return Math.abs(userInput - answer) < epsilon;
    }

}
