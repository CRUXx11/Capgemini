package assignments.assignment3.classes;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component("database")
public class Database {

    private Map<Long , BankAccount> database = new HashMap<>();

    public Database(){
        ///// -----  Already inserting data for creating pre-existing accounts --------//////////
        BankAccount account1 = new BankAccount(123231223L,"Prathamesh Kathade","Savings",34456.90);
        BankAccount account2 = new BankAccount(998922223L,"Rahul Gandhi","Savings",56.73);
        BankAccount account3 = new BankAccount(454531223L,"Narendra Modi","Current",27229816.90);
        this.database.put(account1.getAccountId(),account1);
        this.database.put(account2.getAccountId(),account2);
        this.database.put(account3.getAccountId(),account3);

    }

    public BankAccount getBankAccount(Long accountId){
        return this.database.get(accountId);
    }

    public void insertDataByUser(BankAccount bankAccount){
        this.database.put(bankAccount.getAccountId(),bankAccount);
    }

}
