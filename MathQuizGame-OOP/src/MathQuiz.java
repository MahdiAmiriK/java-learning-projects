import java.util.Scanner;

public class MathQuiz {

    private final Question q;

    // Constructor: inject Scanner into Question
    public MathQuiz(Scanner scanner){
        this.q = new Question(scanner);
    }

    // Start the quiz with 5 questions
    public int startQuiz(){
        int score = 0;
        for (int i = 1 ; i <= 5 ; i++){
            boolean correct = q.question();
            if (correct) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }
        return score;
    }

}
