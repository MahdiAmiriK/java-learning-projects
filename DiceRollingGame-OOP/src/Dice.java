import java.util.Random;

public class Dice {

    private Random random = new Random();

    public int diceRolling(){
        int diceNumber = random.nextInt(6) + 1;
        return diceNumber;
    }
}
