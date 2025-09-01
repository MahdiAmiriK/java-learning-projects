import java.util.ArrayList;

public class BankAccountManagementSystem {
    public static void main(String[] args){
        System.out.println("*** Welcome to the 'Bank Account Management System'***");
        // single service instance for all operations
        BankService service = new BankService();

        boolean exit = false;
        while (!exit){
            showMenu();
            // safe int input
            int menuSelect = InputUtils.getInt("Select from menu");
            switch (menuSelect){
                case 1: // Create account
                    int accType = InputUtils.getInt("Which type of account? " +
                            "1. Saving account or 2. Current account");
                    String accountHolderName = InputUtils.getString("Account holder name");
                    double initialDeposit = InputUtils.getDouble("Initial deposit");
                    switch (accType){
                        case 1: // Savings
                            BankAccount account1 = service.createSavingsAccount(accountHolderName, initialDeposit);
                            System.out.println("The bank account was created with this information: Account Number: " + account1.getAccountNumber() + " | Account holder name: "
                            + account1.getAccountHolderName());
                            break;
                        case 2: // Current
                            BankAccount account2 = service.createCurrentAccount(accountHolderName, initialDeposit);
                            System.out.println("The bank account was created with this information: Account Number: " + account2.getAccountNumber() + " | Account holder name: "
                                    + account2.getAccountHolderName());
                            break;
                    }
                    break;

                case 2: // Deposit
                    String depoAccountNumber = InputUtils.getString("Account number");
                    BankAccount depoAccount = service.findBankAccount(depoAccountNumber);
                    if(depoAccount != null){
                        System.out.print("Account holder name is " + depoAccount.getAccountHolderName() + ", is it correct? ");
                        int correctAccount = InputUtils.getInt("1.Yes or 2. No");
                        switch (correctAccount){
                            case 1:
                                double amount = InputUtils.getDouble("Deposit amount");
                                boolean deposit = service.deposit(depoAccountNumber,amount);
                                System.out.println(deposit ? "Deposit successful" : "Deposit not successful");
                                break;
                            case 2:
                                System.out.println("Try again later.");
                                break;
                        }
                    } else {
                        System.out.println("Unavailable bank account");
                    }
                    break;

                case 3: // Withdraw
                    String witAccountNumber = InputUtils.getString("Account number");
                    BankAccount witAccount = service.findBankAccount(witAccountNumber);
                    if(witAccount != null){
                        System.out.print("Account holder name is " + witAccount.getAccountHolderName() + ", is it correct? ");
                        int correctAccount = InputUtils.getInt("1.Yes or 2. No");
                        switch (correctAccount){
                            case 1:
                                double amount = InputUtils.getDouble("Withdraw amount");
                                boolean withdraw = service.withdraw(witAccountNumber,amount);
                                System.out.println(withdraw ? "Withdraw successful" : "Withdraw not successful");
                                break;
                            case 2:
                                System.out.println("Try again later.");
                                break;
                        }
                    } else {
                        System.out.println("Unavailable bank account");
                    }
                    break;

                case 4: // Check balance
                    String blncAccountNumber = InputUtils.getString("Account number");
                    BankAccount blncAccount = service.findBankAccount(blncAccountNumber);
                    if(blncAccount != null){
                        System.out.print("Account holder name is " + blncAccount.getAccountHolderName() + ", is it correct? ");
                        int correctAccount = InputUtils.getInt("1.Yes or 2. No");
                        switch (correctAccount){
                            case 1:
                                double balance = service.getBalance(blncAccountNumber);
                                System.out.println("Account balance is " + balance);
                                break;
                            case 2:
                                System.out.println("Try again later.");
                                break;
                        }
                    } else {
                        System.out.println("Unavailable bank account");
                    }
                    break;

                case 5: // Transaction history
                    String histAccountNumber = InputUtils.getString("Account number");
                    BankAccount histAccount = service.findBankAccount(histAccountNumber);
                    if(histAccount != null){
                        System.out.print("Account holder name is " + histAccount.getAccountHolderName() + ", is it correct? ");
                        int correctAccount = InputUtils.getInt("1.Yes or 2. No");
                        switch (correctAccount){
                            case 1:
                                ArrayList<double[]> history = service.transactionHistory(histAccountNumber);
                                for (double[] trnsc : history){
                                    System.out.print(trnsc[0]);
                                    System.out.println("\t\t\tbalance: " + trnsc[1]);
                                }
                            case 2:
                                System.out.println("Try again later.");
                                break;
                        }
                    } else {
                        System.out.println("Unavailable bank account");
                    }
                    break;
                case 6: exit = true;

                default: // Unknown menu option
                    System.out.println("Invalid menu choice. Please select 1-6.");
                    break;
            }
        }

    }

    // Prints the main menu
    public static void showMenu(){
        System.out.print("Menu:");
        System.out.print("\t1. Create Account");
        System.out.print("\t2. Deposit Money");
        System.out.print("\t3. Withdraw Money");
        System.out.print("\t4. Check Balance");
        System.out.print("\t5. Transaction History");
        System.out.println("\t6. Exit");
    }
}
