import java.util.Scanner;

public class StarPyramidBuilder {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of levels of the star pyramid: ");
        int num = scanner.nextInt();

        if(num > 0){
            int last = 2 * num - 1;
            for (int i = 0; i < num; i++) {
                for (int s = 0; s <= last; s++) {
                    if (s >= (last/2 +1) -i && s <= (last/2 +1) +i){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println("Invalid input!");
        }
        scanner.close();
    }
}
