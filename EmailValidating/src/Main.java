import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter an email address
        System.out.print("Please enter an email: ");
        String email = scanner.nextLine();

        // Print validation result (true or false)
        System.out.println(validEmail(email));

        scanner.close();
    }

    // Method to check if an email is valid
    public static boolean validEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false; // Email cannot be empty or null
        }

        char[] separatedEmail = email.toCharArray();

        // Check first and last characters for invalid positions
        if (separatedEmail[0] == '@' ||
                separatedEmail[separatedEmail.length - 1] == '@' ||
                separatedEmail[separatedEmail.length - 1] == '.') {
            return false;
        }

        boolean haveAt = false;
        int counter = 0;

        // Loop through each character
        for (int i = 0; i < separatedEmail.length; i++) {
            if (separatedEmail[i] == ' ') {
                return false; // No spaces allowed
            }

            if (separatedEmail[i] == '@') {
                haveAt = true;

                // Check if next char after @ is invalid
                if (separatedEmail[i + 1] == '.' || separatedEmail[i + 1] == '@') {
                    return false;
                }

                // Check for dots and extra @ after the first one
                for (int j = i + 2; j < separatedEmail.length; j++) {
                    if (separatedEmail[j] == '.') {
                        counter++;
                    }
                    if (separatedEmail[j] == '@') {
                        return false;
                    }
                }

                // Email must have at least one '.' after @
                if (counter < 1) {
                    return false;
                }
                break;
            }
        }

        // Email must contain exactly one '@'
        if (!haveAt) {
            return false;
        }

        return true; // Passed all checks
    }
}