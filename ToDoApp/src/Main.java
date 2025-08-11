import java.util.ArrayList;
import java.util.Scanner;

// Simple console-based ToDo application with options to add, edit, mark, and remove tasks
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome to the 'ToDo App' *****");

        ArrayList<String[]> tasks = new ArrayList<>();
        tasks.add(new String[]{"making todo app" , "Not done"});

        boolean exit = false;
        while (!exit){
            System.out.println("********************************************************************************************************************************************");
            int menuChoice = menu(scanner);
            switch (menuChoice){
                case 1: showAllTasks(tasks);
                        break;
                case 2: addTask(tasks, scanner);
                        break;
                case 3: editTask(tasks, scanner);
                        break;
                case 4: markTaskAsDone(tasks, scanner);
                        break;
                case 5: removeTask(tasks, scanner);
                        break;

                case 6: exit = true;
                        break;
                default: System.out.println("Invalid input!");
                        break;
            }
        }

        scanner.close();
    }

    public static int menu(Scanner scanner){
        System.out.println("Menu: 1. View all tasks | 2. Add a task | 3. Edit a task | 4. Mark a task as completed | 5. Remove a task | 6. Exit the application");
        System.out.print("Enter the number of what you want to do: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void addTask(ArrayList<String[]> tasks ,Scanner scanner){
        System.out.print("Enter the task you want to add: ");
        String newTask = scanner.nextLine();
        tasks.add(new String[]{newTask,"Not done"});
    }

    public static void showAllTasks(ArrayList<String[]> tasks){
        if(tasks.isEmpty()){
            System.out.println("Your task list is empty!");
        } else {
            System.out.println("Here are your tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                String[] task = tasks.get(i);
                System.out.println("-----------------------------------");
                System.out.println((i+1) + " | " + task[0] + " | " + task[1]);

            }
        }

    }

    public static void editTask(ArrayList<String[]> tasks, Scanner scanner){
        System.out.print("Enter the number of the task you want to edit: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if(taskNumber > 0 && taskNumber-1 < tasks.size()){
            String[] task = tasks.get(taskNumber-1);
            System.out.println(taskNumber + " | " + task[0] + " | " + task[1]);
            if(task[1].equals("Not done")){
                System.out.println("What do you want to do? 1. Editing the task or 2. Mark this task as DONE");
            } else if (task[1].equals("Done")) {
                System.out.println("What do you want to do? 1. Editing the task or 2. Mark this task as NOT DONE");
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: {
                    System.out.print(task[0] + " should be : ");
                    task[0] = scanner.nextLine();
                    break;
                }
                case 2: task[1] = task[1].equals("Not done") ? "Done" : "Not done";
                        break;
            }

        } else {
            System.out.println("There is no task with the number of " + taskNumber);
        }

    }

    public static void markTaskAsDone(ArrayList<String[]> tasks, Scanner scanner){
        System.out.print("Enter the number of the task that you done: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if(taskNumber > 0 && taskNumber-1 < tasks.size()){
            String[] task = tasks.get(taskNumber-1);
            task[1] = "Done";
        } else {
            System.out.println("There is no task with the number of " + taskNumber);
        }

    }

    public static void removeTask(ArrayList<String[]> tasks, Scanner scanner){
        System.out.print("Enter the number of you want to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        if(taskNumber > 0 && taskNumber-1 < tasks.size()){
            tasks.remove(taskNumber-1);
        } else {
            System.out.println("There is no task with the number of " + taskNumber);
        }
    }
}