package assignments.assignment3.classes;

import assignments.assignment3.interfaces.BankAccountService;


public class BankController {

    BankAccountService bankAccountService;

    public BankController(BankAccountService bankAccountService) {
        super();
        this.bankAccountService = bankAccountService;
    }

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
