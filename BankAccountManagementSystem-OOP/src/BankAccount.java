public abstract class BankAccount {
    private final String accountNumber;

    // Static counter to generate sequential account numbers
    private static int accountCounter = 1000;
    private double balance;
    private String accountHolderName;

   public BankAccount(String accountHolderName, double balance){
       setBalance(balance);
       setAccountHolderName(accountHolderName);
       this.accountNumber = "ACC" + accountCounter++;
   }

    protected void setBalance(double balance){
        if(balance >= 0){
            this.balance = balance;
        } else {
            System.out.println("Unacceptable balance");
            this.balance = 0.0;
        }
    }

    protected void setAccountHolderName(String accountHolderName){
        if(accountHolderName == null || accountHolderName.isEmpty()){
            System.out.println("Account holder name is required.");
        } else {
            this.accountHolderName = accountHolderName;
        }
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        } else {
            System.out.println("Unacceptable deposit!");
        }
    }

    public abstract void withdraw(double amount);

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
