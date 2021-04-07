package assignments.assignment4.Configuration;

import assignments.assignment4.classes.BankController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "assignments.assignment4")
public class assignment4Config {

    @Bean(name = "bankController")
    public BankController getBankController(){
        BankController bankController = new BankController();
        return bankController;
    }

}
