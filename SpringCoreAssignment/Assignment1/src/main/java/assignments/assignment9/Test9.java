package assignments.assignment9;

import assignments.assignment9.classes.FatherBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test9 {

    public static void main(String[] args){

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/assignments/assignment9/assignment9-config.xml");
        FatherBean fatherBean = context.getBean("fatherBean",FatherBean.class);
        System.out.println(fatherBean.toString());
        context.registerShutdownHook();

    }
}
