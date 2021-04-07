package assignments.assignment3.classes;

import assignments.assignment3.interfaces.BankAccountService;
import assignments.assignment3.interfaces.BankAccountRepository;


public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;

    public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

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
