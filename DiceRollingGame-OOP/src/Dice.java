import java.util.Random;

public class Dice {

    private Random random = new Random();
    // Returns a random number between 1 and 6
    public int diceRolling(){
        int diceNumber = random.nextInt(6) + 1;
        return diceNumber;
    }
}
