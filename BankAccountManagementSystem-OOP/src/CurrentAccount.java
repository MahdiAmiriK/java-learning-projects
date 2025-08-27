public class CurrentAccount extends BankAccount{

    // Constructor forwards values to BankAccount
    public CurrentAccount(String accountHolderName, double balance){
        super(accountHolderName,balance);
    }

    @Override
    public void withdraw(double amount) {
        // Allow withdrawal as long as balance does not drop below -500
        if(getBalance() - amount >= -500){
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}
