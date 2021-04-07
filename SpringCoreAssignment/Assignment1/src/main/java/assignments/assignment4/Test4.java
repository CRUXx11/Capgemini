package assignments.assignment4;

import assignments.assignment4.Configuration.assignment4Config;
import assignments.assignment4.classes.BankController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

///--------------Pre-Inserted Values To Test -------------------///////

//        BankAccount(123231223L,"Prathamesh Kathade","Savings",34456.90);
//        BankAccount(998922223L,"Rahul Gandhi","Savings",56.73);
//        BankAccount(454531223L,"Narendra Modi","Current",27229816.90);


public class Test4 {
    public static void main(String[] args){
        Long accountId = 123231223L;
        Double depositBalance = 21083.42;
       try {
           ApplicationContext applicationContext = new AnnotationConfigApplicationContext(assignment4Config.class);
           BankController bankController = applicationContext.getBean("bankController", BankController.class);
           System.out.println("Balance in accountId: " + accountId + " is " + bankController.getBalance(accountId));
           System.out.println("Depositing balance Rs." + depositBalance + " to accountId:" + accountId);
           bankController.deposit(accountId, depositBalance);
           System.out.println("Current Balance after depositing : " + bankController.getBalance(accountId));
       }catch (NullPointerException n){
           System.out.println("No User found with accountId: "+ accountId);
       } catch (Exception e){
           System.out.println("Exception in Test4.Java");
           e.printStackTrace();
       }

    }
}
