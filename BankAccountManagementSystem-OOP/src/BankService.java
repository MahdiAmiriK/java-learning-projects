import java.util.ArrayList;

public class BankService {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

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
        for(BankAccount account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                double beforeBalance = account.getBalance();
                account.deposit(amount);
                double afterBalance = account.getBalance();
                if(beforeBalance == afterBalance){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

}
