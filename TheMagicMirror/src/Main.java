import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the magic mirror app!");

        // Ask user for a word
        System.out.print("Enter your word: ");
        String userInput = scanner.nextLine();

        // Reverse the string using recursion
        String mirror = magicmirror(userInput);

        // Display reversed string
        System.out.println(mirror);

        scanner.close();
    }

    // Method to reverse a string using recursion
    public static String magicmirror(String str) {
        if (!str.isEmpty()) {
            return str.charAt(str.length() - 1) + magicmirror(str.substring(0, str.length() - 1));
        }
        return "";
    }
}