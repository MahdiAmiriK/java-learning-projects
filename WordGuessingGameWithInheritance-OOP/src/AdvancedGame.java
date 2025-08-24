import java.util.Random;

public class AdvancedGame extends InputGame{
    // random-based hint strategy (reveals random letters)
    protected Random random;

    public AdvancedGame(String guessingWord){
        super(guessingWord);
        this.random = new Random();
    }

    @Override
    public void displayHint(){
        super.displayHint();
        System.out.println(revealedWord());
        updateRevealedWord();
    }

    // reveal one random '-' position (if any) with the correct letter
    private void updateRevealedWord(){
        if(new String(revealedLetters).indexOf('-') == -1){
            return;
        }
        while (true){
            int randomIndex = random.nextInt(guessingWord.length());
            if(revealedLetters[randomIndex] == '-'){
                revealedLetters[randomIndex] = guessingWord.charAt(randomIndex);
                break;
            }
        }
    }


}
