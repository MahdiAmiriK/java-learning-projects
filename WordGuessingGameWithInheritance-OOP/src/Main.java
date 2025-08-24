import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] words = {
                "apple", "zebra", "computer", "coffee", "jungle", "river", "pencil", "mirror", "school", "cloud",
                "banana", "train", "tiger", "camera", "purple", "music", "sun", "moon", "ocean", "phone",
                "chair", "desk", "forest", "pizza", "house", "garden", "flower", "bread", "book", "pen",
                "dog", "cat", "horse", "car", "bus", "plane", "ship", "robot", "mouse", "keyboard",
                "earth", "sky", "star", "dream", "goal", "light", "dark", "rain", "snow", "storm",
                "stone", "tree", "leaf", "fire", "water", "wind", "mountain", "valley", "desert", "island",
                "song", "dance", "game", "sport", "team", "ball", "goalkeeper", "stadium", "coach", "player",
                "table", "window", "door", "road", "bridge", "tower", "castle", "village", "city", "country",
                "guitar", "piano", "drum", "violin", "flute", "trumpet", "songwriter", "concert", "stage", "radio",
                "lion", "bear", "fox", "wolf", "rabbit", "deer", "camel", "panda", "snake", "frog"
        };
        Random random = new Random();
        AdvancedGame game = new AdvancedGame(words[random.nextInt(words.length)]);
        game.playGame();

    }
}
