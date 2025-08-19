import java.util.Random;

public class Dice {

    private Random random = new Random();
    private int min = 1, max = 6;

    public int diceRolling(){
        int diceNumber = random.nextInt((max - min +1) + min);
        return diceNumber;
    }
}
