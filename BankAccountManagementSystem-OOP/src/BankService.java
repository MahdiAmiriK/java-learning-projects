import java.util.ArrayList;

public class BankService {
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

    public BankAccount findBankAccount(String accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public boolean deposit(String accountNumber, double amount){
        BankAccount account = findBankAccount(accountNumber);
        if(account == null || amount <=0){
            return false;
        }
        account.deposit(amount);
        return true;
    }

    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = findBankAccount(accountNumber);
        if(account == null || amount <=0){
            return false;
        }
        double beforeBalance = account.getBalance();
        account.withdraw(amount);
        double afterBalance = account.getBalance();
        if(beforeBalance != afterBalance){
            return true;
        }
        return false;
    }

    public Double getBalance(String accountNumber) {
        BankAccount account = findBankAccount(accountNumber);
        if(account == null){
            return null;
        } else {
            return account.getBalance();
        }
    }

}
