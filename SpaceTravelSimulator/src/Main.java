import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List of astronauts: each astronaut = [name, age, status]
        ArrayList<ArrayList<String>> mission = new ArrayList<>();

        // Welcome + wait for Enter
        System.out.println("***** Welcome to the Space Travel Simulation *****");
        System.out.print("Press Enter to see mission's staff: ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Temporary holder for user input
        ArrayList<String> person = new ArrayList<>();

        // Main loop
        do {
            if (!mission.isEmpty()) {
                // Show all astronauts
                System.out.println("*** Astronuts ***");
                for (int i = 0; i < mission.size(); i++) {
                    System.out.print("Id: " + (i + 1));
                    System.out.print(" / Name: " + mission.get(i).get(0));
                    System.out.print(" / Age: " + mission.get(i).get(1));
                    System.out.print(" / Status: " + mission.get(i).get(2));
                    System.out.println();
                }

                // Menu
                System.out.println("What do you want to do? \n1- Adding an astronut \n2- Editing an astronut \n3- Exit the program");
                int choice1 = scanner.nextInt();
                scanner.nextLine();

                if (choice1 == 1) {
                    // Add new astronaut
                    System.out.print("Enter name: ");
                    person.add(scanner.nextLine());
                    System.out.print("Enter age: ");
                    person.add(scanner.nextLine());
                    System.out.print("Enter status: ");
                    person.add(scanner.nextLine());
                    mission.add(new ArrayList<>(person)); // store a copy
                    person.clear(); // reset temp list

                } else if (choice1 == 2) {
                    // Edit existing astronaut
                    System.out.print("Which astronut you want to edit? Enter the ID: ");
                    int id = scanner.nextInt();

                    if (id > 0 && id <= mission.size()) {
                        System.out.println("You want to edit this astronut: ");

                        // Edit loop
                        do {
                            System.out.print("Name: " + mission.get(id - 1).get(0));
                            System.out.print(" / Age: " + mission.get(id - 1).get(1));
                            System.out.print(" / Status: " + mission.get(id - 1).get(2));
                            System.out.println();

                            System.out.println("What do you want to change? \n1- Name \n2- Age \n3- Status \n4- Delete the astronut \n5- Exit the editing mode");
                            int choice3 = scanner.nextInt();
                            scanner.nextLine();

                            if (choice3 == 1) {
                                System.out.print("Enter the new name: ");
                                mission.get(id - 1).set(0, scanner.nextLine());
                            } else if (choice3 == 2) {
                                System.out.print("Enter the new age: ");
                                mission.get(id - 1).set(1, scanner.nextLine());
                            } else if (choice3 == 3) {
                                System.out.print("Enter the new status: ");
                                mission.get(id - 1).set(2, scanner.nextLine());
                            } else if (choice3 == 4) {
                                mission.remove(id - 1); // delete astronaut
                                break;
                            } else {
                                break; // exit editing
                            }
                        } while (true);
                    } else {
                        System.out.println("This id is not valid");
                    }

                } else {
                    break; // exit program
                }

            } else {
                // Empty list: ask to add first astronaut or exit
                System.out.println("There is no one in this mission.");
                System.out.println("What do you want to do? \n1- Adding a astronut to the mission? \n2- Exit the program");
                int choice2 = scanner.nextInt();
                scanner.nextLine();

                if (choice2 == 1) {
                    System.out.print("Enter name: ");
                    person.add(scanner.nextLine());
                    System.out.print("Enter age: ");
                    person.add(scanner.nextLine());
                    System.out.print("Enter status: ");
                    person.add(scanner.nextLine());
                    mission.add(new ArrayList<>(person));
                    person.clear();
                } else {
                    break; // exit
                }
            }
        } while (true);

        scanner.close();
    }
}