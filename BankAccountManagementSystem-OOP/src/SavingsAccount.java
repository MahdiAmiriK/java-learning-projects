public class SavingsAccount extends BankAccount{

    // Constructor forwards values to BankAccount
    public SavingsAccount(String accountHolderName, double balance){
        super(accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        // Ensure minimum balance of $100
        if(getBalance() - amount >= 100){
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Unacceptable fund. Minimum balance of $100 required.");
        }
    }
}
