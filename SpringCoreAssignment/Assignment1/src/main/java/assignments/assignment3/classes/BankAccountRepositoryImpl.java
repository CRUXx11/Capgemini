package assignments.assignment3.classes;

import assignments.assignment3.interfaces.BankAccountRepository;


public class BankAccountRepositoryImpl implements BankAccountRepository {

    Database database;

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Double getBalance(Long accountId){
        return this.database.getBankAccount(accountId).getAccountBalance();
    }

    public Double updateBalance(Long accountId, Double newBalance){
           this.database.getBankAccount(accountId).setAccountBalance(newBalance);
           return this.database.getBankAccount(accountId).getAccountBalance();
    }


}
