public class Game {
    // base class: holds the word, attempts, and revealed letters
    protected String guessingWord;
    protected int attempts;
    protected char[] revealedLetters;

    public Game(String guessingWord){
        this.guessingWord = guessingWord;
        this.attempts = 0;
        this.revealedLetters = new char[guessingWord.length()];
        for (int i = 0; i < guessingWord.length(); i++) {
            revealedLetters[i] = '-';
        }
    }

    public void playGame(){
        System.out.println("***** Welcome to this guessing word game *****");
    }

    public void displayHint(){
        System.out.println("This word has " + guessingWord.length() + " letters.");
    }

    public String revealedWord(){
        return new String(revealedLetters);
    }

}
