import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome
        System.out.println("**** Welcome to the 'Word Scramble Game' ****");
        getUserInput(scanner,"Are you ready? Press Enter: " );

        int score = 0;
        int strike = 0;
        String guess;
        String[] roundWord;
        boolean end = false;

        // Game loop
        do {
            roundWord = scrambleWord();
            do {
                if (strike == 3) {
                    System.out.println("Warning! Last chance!");
                }

                // Guess the word
                guess = getUserInput(scanner,"Guess the word '" + roundWord[1] +"': ");

                if (guess.equals(roundWord[0])) {
                    score++;
                    System.out.println(encouragement());
                    System.out.println("Score: " + score);
                    System.out.println("Strikes: " + strike + "/3");
                    String again = getUserInput(scanner,"Continue? (yes/no): ");
                    if (again.equals("yes")) {
                        end = false;
                        break;
                    } else {
                        System.out.println("Game Over!");
                        System.out.println("Final score: " + score);
                        end = true;
                        break;
                    }
                } else {
                    System.out.println(wrongAnswer());
                    strike++;
                    if (strike > 3) {
                        System.out.println("Correct word: '" + roundWord[0] + "'.");
                        System.out.println("Game Over!");
                        System.out.println("Score: " + score);
                        end = true;
                        break;
                    }
                    System.out.println("Strikes: " + strike + "/3");
                    String again = getUserInput(scanner,"Guess again or pass? (yes/pass): ");
                    if (!again.equals("yes")) {
                        System.out.println("Correct word: '" + roundWord[0] + "'.");
                        System.out.println("Strikes: " + strike + "/3");
                        System.out.println("Score: " + score);
                        end = false;
                        break;
                    }
                }
            } while (true);
        } while (!end);

        scanner.close();
    }

    // Get random word and scramble
    public static String[] scrambleWord(){
        String[] wordList = {
                "apple", "banana", "grape", "cherry", "peach", "lemon", "mango", "melon", "plum",
                "car", "train", "plane", "boat", "bike", "bus", "truck", "subway", "scooter", "helicopter",
                "dog", "cat", "mouse", "rabbit", "lion", "tiger", "bear", "fox", "wolf", "monkey",
                "red", "blue", "green", "yellow", "black", "white", "pink", "purple", "orange", "gray",
                "sun", "moon", "star", "cloud", "rain", "snow", "wind", "storm", "sky", "lightning",
                "table", "chair", "bed", "door", "window", "lamp", "sofa", "mirror", "shelf", "desk",
                "run", "walk", "jump", "sit", "stand", "sleep", "eat", "drink", "read", "write",
                "happy", "sad", "angry", "tired", "hungry", "scared", "bored", "excited", "funny", "kind",
                "school", "book", "pen", "pencil", "paper", "bag", "teacher", "student", "class", "lesson",
                "city", "village", "house", "street", "bridge", "river", "park", "mountain", "forest", "beach"
        };

        Random random = new Random();
        String word = wordList[random.nextInt(wordList.length)];

        char[] letters = word.toCharArray();
        char[] scramble = new char[letters.length];
        ArrayList<Integer> used = new ArrayList<>();

        for (int i = 0; i < letters.length; i++) {
            int rand;
            do {
                rand = random.nextInt(0, letters.length);
            } while (used.contains(rand));
            scramble[rand] = letters[i];
            used.add(rand);
        }

        return new String[]{word, new String(scramble)};
    }

    // Random encouragement
    public static String encouragement(){
        String[] encouragements = {
                "Great job!", "Excellent!", "Well done!", "Awesome!", "You're amazing!",
                "Keep it up!", "Nice work!", "Fantastic!", "Superb!", "Very good!"
        };
        Random random = new Random();
        return encouragements[random.nextInt(encouragements.length)];
    }

    // Random wrong answer
    public static String wrongAnswer(){
        String[] feedbackWrong = {
                "Incorrect!", "Wrong answer!", "That's not correct.", "Nope, wrong!", "That is wrong."
        };
        Random random = new Random();
        return feedbackWrong[random.nextInt(feedbackWrong.length)];
    }

    // Get input from user
    public static String getUserInput(Scanner scanner, String message){
        System.out.print(message);
        return scanner.nextLine();
    }
}