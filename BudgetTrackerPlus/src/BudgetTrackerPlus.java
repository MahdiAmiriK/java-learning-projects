import java.util.Scanner;

public class BudgetTrackerPlus {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Get monthly income from user
        System.out.print("Please enter your monthly income: ");
        double income = scanner.nextDouble();

        // Get different expense categories from user
        System.out.print("Please enter expenses for Rent: ");
        double rent = scanner.nextDouble();

        System.out.print("Please enter expenses for Groceries: ");
        double groceries = scanner.nextDouble();

        System.out.print("Please enter expenses for Transportation: ");
        double transportation = scanner.nextDouble();

        System.out.print("Please enter expenses for Entertainment: ");
        double entertainment = scanner.nextDouble();

        // Calculate total expenses and remaining budget
        double totalExpenses = rent + groceries + transportation + entertainment;
        double remainingBudget = income - totalExpenses;

        // Calculate percentage of income spent on each category
        double rentPercent = (100 * rent) / income;
        double groceriesPercent = (100 * groceries) / income;
        double transportationPercent = (100 * transportation) / income;
        double entertainmentPercent = (100 * entertainment) / income;

        // Display budget summary
        System.out.println("\n*** Budget summary ***");
        System.out.println("Total expenses: " + totalExpenses);
        System.out.println("Percentage of income spent on rent: " + rentPercent);
        System.out.println("Percentage of income spent on groceries: " + groceriesPercent);
        System.out.println("Percentage of income spent on transportation: " + transportationPercent);
        System.out.println("Percentage of income spent on entertainment: " + entertainmentPercent);
        System.out.println("Remaining budget: " + remainingBudget);

        scanner.close();
    }
}