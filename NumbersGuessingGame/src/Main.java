import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the number guessing game!");
        System.out.println("Think of a number between 1 and 100 (inclusive) and press enter");
        scanner.nextLine(); // Wait for user to think of a number

        // Start guessing using binary search logic
        int guess = guessingNumber(0, 100, scanner);
        System.out.println("Yoohoo! Your number is " + guess);

        scanner.close();
    }

    // Method to guess the number using binary search
    public static int guessingNumber(int min, int max, Scanner scanner) {
        int guess;
        while (min <= max) {
            guess = (max + min) / 2; // Middle point
            System.out.println("Is your number " + guess + "?");
            System.out.println("If yes enter 'c'\nIf your number is higher than " + guess + " enter 'h'\nIf your number is lower than " + guess + " enter 'l'");

            char userInput = scanner.next().charAt(0);

            switch (userInput) {
                case 'c' -> {
                    return guess; // Correct guess
                }
                case 'h' -> min = guess + 1; // Number is higher
                case 'l' -> max = guess - 1; // Number is lower
                default -> System.out.println("Invalid input");
            }
        }
        System.out.println("It seems something went wrong with the guessing.");
        return -1;
    }
}