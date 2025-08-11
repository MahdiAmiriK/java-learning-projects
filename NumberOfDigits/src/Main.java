import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Display the number of digits using recursion
        System.out.println(num + " has " + digitCounter(num) + " digits.");

        scanner.close();
    }

    // Recursive method to count digits in a number
    public static int digitCounter(int num) {
        if (num < 0) { // Handle negative numbers
            return digitCounter(-1 * num);
        }
        if (num < 10) { // Base case: single-digit number
            return 1;
        }
        return 1 + digitCounter(num / 10); // Recursive step
    }
}