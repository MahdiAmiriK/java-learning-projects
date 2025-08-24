import java.util.Scanner;

public class InputGame extends Game {
    // subclass: adds user input handling with Scanner
    protected Scanner scanner;

    public InputGame(String guessingWord){
        super(guessingWord);
        this.scanner = new Scanner(System.in);
    }

    // main loop of the game
    @Override
    public void playGame(){
        super.playGame();
        do {
            displayHint();
            if(attempts < guessingWord.length()-1){
                System.out.print("Enter your guess: ");
            }
            String userInput = scanner.nextLine();
            if(guessingWord.equalsIgnoreCase(userInput)){
                System.out.println("You won!");
                break;
            }else if (attempts < guessingWord.length()-1){
                System.out.println("Wrong answer, try again");
            } else {
                System.out.println("You lost!");
                System.out.println("The word was " + guessingWord);
            }
            attempts++;

        } while (attempts < guessingWord.length());
        scanner.close();
    }

}
