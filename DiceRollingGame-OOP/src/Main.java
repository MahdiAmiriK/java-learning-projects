
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome to dice rolling game *****");
        System.out.print("To start the game please press Enter: ");
        scanner.nextLine();
        Game game = new Game(scanner);
        game.gameStart();
        scanner.close();
    }
}