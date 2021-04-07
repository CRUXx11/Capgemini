package assignments.assignment10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test10  {

    public static void main(String[] args){
        new ApplicationContextImpl().setApplicationContext(new ClassPathXmlApplicationContext("file:src/main/java/assignments/assignment10/assignment10-config.xml"));
    }
}
