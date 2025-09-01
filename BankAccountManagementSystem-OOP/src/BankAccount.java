import java.util.ArrayList;

public abstract class BankAccount {

    private final String accountNumber;
    private double balance = 0;
    private String accountHolderName;
    private final ArrayList<double[]> TransactionHistory = new ArrayList<>();

   public BankAccount(String accountNumber, String accountHolderName, double initialDeposit){
       this.accountNumber = accountNumber;
       deposit(initialDeposit);
       setAccountHolderName(accountHolderName);

   }

    protected void setAccountHolderName(String accountHolderName){
        if(accountHolderName == null || accountHolderName.isEmpty()){
            System.out.println("Account holder name is required.");
            this.accountHolderName = "Unknown";
        } else {
            this.accountHolderName = accountHolderName;
        }
    }

    // Apply a transaction: update balance and log it in history
    protected void applyTransaction(double amount){
        balance += amount;
        setHistory(amount, balance);
    }

    // Deposit money into the account
    public void deposit(double amount){
        if(amount >= 0){
            applyTransaction(amount);
        } else {
            System.out.println("Deposit amount must be positive");
        }
    }

    // Withdraw money from the account (implemented by subclasses)
    public abstract void withdraw(double amount);

   // Record a transaction in history
    private void setHistory(double amount, double balance){
        TransactionHistory.add(new double[]{amount, balance});
    }

    public ArrayList<double[]> getHistory(){
        return TransactionHistory;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

}
