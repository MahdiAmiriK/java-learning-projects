import java.util.Random;
import java.util.Scanner;

public class Game {

    private int score = 0;

    Random random = new Random();
    private int targetScore = random.nextInt(11) + 2;

    private Scanner scanner;

    public Game(Scanner scanner){
        this.scanner = scanner;
    }

    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

    public void gameStart(){

        int diceNum1 = dice1.diceRolling();
        int diceNum2 = dice2.diceRolling();
        score = score + diceNum1 + diceNum2;

        if(score == targetScore){
            System.out.println("Congrats! You win the game.");
            System.out.println("Target score was " + targetScore + " and you roll " + score);
        }else{
            System.out.println("Oops! You lose.");
            System.out.println("Target score was " + targetScore + " and you roll " + score);

            while (true){
                System.out.print("Do you want to roll again? (yes/no) ");
                String userDecision = scanner.nextLine();
                if (userDecision.equalsIgnoreCase("yes")){
                    gameStart();
                    break;
                } else if (userDecision.equalsIgnoreCase("no")) {
                    System.out.println("Game Over!");
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }

        }

    }

}
