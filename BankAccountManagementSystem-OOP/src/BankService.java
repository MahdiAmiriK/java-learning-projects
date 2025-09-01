import java.util.ArrayList;

public class BankService {
    // Stores all created bank accounts
    private final ArrayList<BankAccount> accounts = new ArrayList<>();

    public BankAccount createSavingsAccount(String accountHolderName, double initialDeposit){
        BankAccount account = new SavingsAccount(accountHolderName, initialDeposit);
        accounts.add(account);
        return account;
    }

    public BankAccount createCurrentAccount(String accountHolderName, double initialDeposit){
        BankAccount account = new CurrentAccount(accountHolderName, initialDeposit);
        accounts.add(account);
        return account;
    }

    // Search for an account by its account number
    public BankAccount findBankAccount(String accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    // Deposit money into an account; return true if successful
    public boolean deposit(String accountNumber, double amount){
        BankAccount account = findBankAccount(accountNumber);
        if(account == null || amount <=0){
            return false;
        }
        account.deposit(amount);
        return true;
    }

    // Withdraw money from an account; return true if balance actually changed
    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = findBankAccount(accountNumber);
        if(account == null || amount <=0){
            return false;
        }
        double beforeBalance = account.getBalance();
        account.withdraw(amount);
        double afterBalance = account.getBalance();
        return beforeBalance != afterBalance;
    }

    // Get the balance of an account, or null if account not found
    public Double getBalance(String accountNumber) {
        BankAccount account = findBankAccount(accountNumber);
        if(account == null){
            return null;
        } else {
            return account.getBalance();
        }
    }

    // Get the transaction history of an account, or null if account not found
    public ArrayList<double[]> transactionHistory(String accountNumber){
        BankAccount account = findBankAccount(accountNumber);
        if(account == null){
            return null;
        } else {
            return account.getHistory();
        }
    }

}
