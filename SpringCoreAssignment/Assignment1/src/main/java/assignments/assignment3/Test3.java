package assignments.assignment3;

import assignments.assignment3.classes.BankController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

//   ---------------- VALUES IN DATABASE ------
//   (123231223L,"Prathamesh Kathade","Savings",34456.90);
//    (998922223L,"Rahul Gandhi","Savings",56.73);
//    (454531223L,"Narendra Modi","Current",27229816.90);

    public static void main(String[] args){
        Long accountId = 998922223L;
        Double depositBalance = 87283.42;
        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:src/main/java/assignments/assignment3/assignment3-config.xml");
            BankController bankController = applicationContext.getBean("bankController",BankController.class);
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
