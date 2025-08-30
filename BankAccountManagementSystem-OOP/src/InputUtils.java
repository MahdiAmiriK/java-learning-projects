import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private InputUtils(){}

    // Read a String input from user safely
    public static String getString(String prompt){
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    // Read an integer input from user safely
    public static int getInt(String prompt){
        while (true) {
            System.out.print(prompt + ": ");
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    // Read a double input from user safely
    public static double getDouble(String prompt){
        while (true){
            System.out.print(prompt + ": ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println("Enter a valid number.");
            }
        }
    }

}
