import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu
        System.out.println("Welcome to the Encoder-Decoder Game!");
        System.out.println("1. Encode a string");
        System.out.println("2. Decode a string");
        System.out.print("Choose an option (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        if (choice == 1) {
            // Encoding mode
            System.out.print("Enter a String to encode: ");
            String text = scanner.nextLine();
            String result = encode(text);
            System.out.print("Encoded value of " + text + " is: " + result);
        } else if (choice == 2) {
            // Decoding mode
            System.out.print("Enter a String to decode: ");
            String text = scanner.nextLine();
            String result = decode(text);
            System.out.print("Decoded value of " + text + " is: " + result);
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }

    // Atbash cipher transformation for a single character
    public static char atbash(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('z' - (ch - 'a'));
        } else if (ch >= 'A' && ch <= 'Z') {
            return (char) ('Z' - (ch - 'A'));
        } else {
            return ch; // Non-alphabet characters remain unchanged
        }
    }

    // Encode a string recursively
    public static String encode(String s) {
        if (!s.isEmpty()) {
            char firstChar = s.charAt(0);
            return atbash(firstChar) + encode(s.substring(1));
        }
        return "";
    }

    // Decode a string recursively (same logic as encode for Atbash)
    public static String decode(String s) {
        if (!s.isEmpty()) {
            char firstChar = s.charAt(0);
            return atbash(firstChar) + decode(s.substring(1));
        }
        return "";
    }
}