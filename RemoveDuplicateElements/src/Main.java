import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Example array with duplicate values
        int[] arr = {1, 3, 7, 3, 4, 1, 6, 9, 23, 45, 675, 3, 5};

        // Print array after removing duplicates
        System.out.println(removeDuplicate(arr));
    }

    // Method to remove duplicate elements from an array
    public static ArrayList<Integer> removeDuplicate(int[] arr) {
        ArrayList<Integer> nonDuplicateArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Add the element if it's not already in the list
            if (!nonDuplicateArr.contains(arr[i])) {
                nonDuplicateArr.add(arr[i]);
            }
        }
        return nonDuplicateArr;
    }
}