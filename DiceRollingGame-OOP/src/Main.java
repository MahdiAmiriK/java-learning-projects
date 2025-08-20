import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome to dice rolling game *****");
        System.out.print("To start the game please press Enter: ");
        scanner.nextLine();
        Game game = new Game(scanner);
        game.gameStart(); // start the game
        scanner.close();
    }
}