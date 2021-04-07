package assignments.assignment4.classes;

import assignments.assignment4.interfaces.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("bankAccountRepositoryImpl")
public class BankAccountRepositoryImpl implements BankAccountRepository {

    @Autowired
    @Qualifier("database")
    Database database;

    public Double getBalance(Long accountId){
        return this.database.getBankAccount(accountId).getAccountBalance();
    }

    public Double updateBalance(Long accountId, Double newBalance){
           this.database.getBankAccount(accountId).setAccountBalance(newBalance);
           return this.database.getBankAccount(accountId).getAccountBalance();
    }


}
