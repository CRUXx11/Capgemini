package assignments.assignment4.classes;

import assignments.assignment4.interfaces.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller("bankController")
public class BankController {

    @Autowired
    @Qualifier("bankAccountServiceImpl")
    BankAccountService bankAccountService;

    public Double withdraw(Long accountId, Double balance){
        return this.bankAccountService.withdraw(accountId,balance);
    }

    public Double deposit(Long accountId, Double balance){
        return this.bankAccountService.deposit(accountId,balance);
    }
    public Double getBalance(Long accountId){
        return this.bankAccountService.getBalance(accountId);
    }
    public Boolean fundTransfer(Long fromAccount, Long toAccount, Double amount){
        return this.bankAccountService.fundTransfer(fromAccount,toAccount,amount);
    }

}
