package assignments.assignment4.classes;

import assignments.assignment4.interfaces.BankAccountRepository;
import assignments.assignment4.interfaces.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("bankAccountServiceImpl")
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    @Qualifier("bankAccountRepositoryImpl")
    BankAccountRepository bankAccountRepository;

    public Double withdraw(Long accountId, Double balance){

        Double currentBalance = this.bankAccountRepository.getBalance(accountId);
        if(currentBalance >= balance) {
            this.bankAccountRepository.updateBalance(accountId,currentBalance-balance);
        }
        else {
            System.out.println("Error: Cant withdraw!! Current balance is less than Withdrawal balance.");
            System.out.println("Current Balance: "+currentBalance + " Withdrawal Balance:"+ balance);
        }
        return this.bankAccountRepository.getBalance(accountId);
    }


    public Double deposit(Long accountId, Double balance){

        Double currentBalance = this.bankAccountRepository.getBalance(accountId);
        this.bankAccountRepository.updateBalance(accountId,currentBalance+balance);
        return this.bankAccountRepository.getBalance(accountId);

    }


    public Double getBalance(Long accountId){

        return this.bankAccountRepository.getBalance(accountId);

    }


    public Boolean fundTransfer(Long fromAccount, Long toAccount, Double amount){

        Double fromAccountBalance = this.bankAccountRepository.getBalance(fromAccount);
        Double toAccountBalance = this.bankAccountRepository.getBalance(toAccount);
        if(amount > fromAccountBalance){
            return false;
        }
        this.bankAccountRepository.updateBalance(fromAccount,fromAccountBalance-amount);
        this.bankAccountRepository.updateBalance(toAccount,toAccountBalance+amount);
        return true;
    }

}
