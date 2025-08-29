public class SavingsAccount extends BankAccount{

    // Static counter to generate sequential account numbers
    private static int accountCounter = 1000;

    // Constructor forwards values to BankAccount
    public SavingsAccount(String accountHolderName, double initialDeposit){
        super("ACS" + accountCounter++,accountHolderName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        // Prevent zero or negative withdrawal
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        // Ensure minimum balance of $100
        if(getBalance() - amount >= 100){
            applyTransaction(-1 * amount);
        } else {
            System.out.println("Unacceptable fund. Minimum balance of $100 required.");
        }
    }
}
