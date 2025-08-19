import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int score = 0;

    Random random = new Random();

    private Scanner scanner;

    public Game(Scanner scanner){
        this.scanner = scanner;
    }

    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

    private int[] rollDices(){
        int diceNum1 = dice1.diceRolling();
        int diceNum2 = dice2.diceRolling();
        int[] result = {diceNum1,diceNum2};
        return result;
    }

    public void gameStart(){
        int targetScore = random.nextInt(11) + 2;
        System.out.println("Target score is " + targetScore);

        while (true){
            System.out.println("To roll the dice press enter");
            scanner.nextLine();
            int[] dice = rollDices();
            score = dice[0] + dice[1];

            if(score == targetScore){
                System.out.println("Congrats! You win the game.");
                System.out.println("Target score was " + targetScore + " and you roll " + dice[0] + " and " + dice[1]);
                break;
            } else if (dice[0] == dice[1]) {
                System.out.println("You roll a double (" + dice[0] + " and " + dice[1] + ") and you can roll again.");
                continue;
            } else{
                System.out.println("Oops! You lose.");
                System.out.println("Target score was " + targetScore + " and you roll " + dice[0] + " and " + dice[1]);

                while (true){
                    System.out.print("Do you want to roll again? (yes/no) ");
                    String userDecision = scanner.nextLine();
                    if (userDecision.equalsIgnoreCase("yes")){
                        score = 0;
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
}
