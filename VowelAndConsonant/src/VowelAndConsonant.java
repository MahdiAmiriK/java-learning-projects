import java.util.Scanner;

// Counts vowels, consonants, and non-alphabet characters in a string
public class VowelAndConsonant {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter a string (type 'close' to exit): ");
            input = scanner.nextLine();

            int vowel = 0, cons = 0, notAlph = 0;

            // Go through each character
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){ // check lowercase
                    switch (input.charAt(i)){
                        case 'a': case 'e': case 'i': case 'o': case 'u': case 'y':
                            vowel++;
                            break;
                        default:
                            cons++;
                            break;
                    }
                } else {
                    notAlph++;
                }
            }

            // Show result
            System.out.println("Vowels: " + vowel + ", Consonants: " + cons + ", Non-letters: " + notAlph);
        } while (!input.equals("close"));

        scanner.close();
    }
}