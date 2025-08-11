import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            int menuChoice = menu(scanner);
            switch (menuChoice) {
                case 1: // Add new student
                    makingNewStudent(students, scanner);
                    break;
                case 2: // Show statistics
                    showStatistic(students, scanner);
                    break;
                case 3: // Exit
                    exit = true;
                    break;
            }
        }

        scanner.close();
    }

    // Show menu and return user's choice
    public static int menu(Scanner scanner) {
        System.out.print("Menu: 1. Adding a student | 2. Show statistics | 3. Exit the Program: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    // Create a new student and add to list
    public static void makingNewStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("Add a student");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Height: ");
        int height = scanner.nextInt();
        scanner.nextLine();

        students.add(new Student(name, rollNumber, age, height));
    }

    // Calculate and show student statistics
    public static void showStatistic(ArrayList<Student> students, Scanner scanner) {
        int ageSum = 0;
        int heightSum = 0;
        int oldestAge = 0;
        String oldestStudent = "";
        int tallestHeight = 0;
        String tallestStudent = "";

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            ageSum += student.age;
            heightSum += student.height;
            if (student.age > oldestAge) {
                oldestAge = student.age;
                oldestStudent = student.name;
            }
            if (student.height > tallestHeight) {
                tallestHeight = student.height;
                tallestStudent = student.name;
            }
        }
        System.out.println("Average age of students: " + ageSum / students.size());
        System.out.println("Average height of students: " + heightSum / students.size());
        System.out.println("Oldest student is: " + oldestStudent);
        System.out.println("Tallest student is: " + tallestStudent);
    }
}