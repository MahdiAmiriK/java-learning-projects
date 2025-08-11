import java.util.Scanner;

public class HarshadNumber {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        // Get number from user
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();

        int num = input, sum = 0;

        // Calculate sum of digits
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        // Check if number is divisible by sum of digits
        if(input % sum == 0){
            System.out.println(input + " is a harshad number.");
        } else {
            System.out.println(input + " is not a harshad number.");
        }

        scanner.close();
    }
}