package assignments.assignment8.ByAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "assignments.assignment8")
public class assignment8Config {

    @Autowired
    private Drink drink1;

}
