public abstract class BankAccount {

    private final String accountNumber;
    private double balance;
    private String accountHolderName;

   public BankAccount(String accountNumber, String accountHolderName, double initialDeposit){
       this.accountNumber = accountNumber;
       setBalance(initialDeposit);
       setAccountHolderName(accountHolderName);
   }


    protected void setBalance(double initialDeposit){
        if(initialDeposit >= 0){
            balance = initialDeposit;
        } else {
            System.out.println("Unacceptable balance");
            balance = 0.0;
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
