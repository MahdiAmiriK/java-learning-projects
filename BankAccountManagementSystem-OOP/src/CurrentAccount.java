public class CurrentAccount extends BankAccount{

    // Static counter to generate sequential account numbers
    private static int accountCounter = 1000;

    // Constructor forwards values to BankAccount
    public CurrentAccount(String accountHolderName, double initialDeposit){
        super("ACC" + accountCounter++,accountHolderName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        // Prevent zero or negative withdrawal
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        // Allow withdrawal as long as balance does not drop below -500
        if(getBalance() - amount >= -500){
            applyTransaction(-1 * amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}
