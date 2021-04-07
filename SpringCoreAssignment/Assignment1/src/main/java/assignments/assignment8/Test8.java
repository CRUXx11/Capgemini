package assignments.assignment8;

import assignments.assignment8.ByAnnotation.Drink;
import assignments.assignment8.ByAnnotation.assignment8Config;
import assignments.assignment8.ByInterface.Table;
import assignments.assignment8.ByXML.Food;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test8 {

    public static void main(String[] args){

        AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("file:src/main/java/assignments/assignment8/ByXML/assignment8-config.xml");
        Food food1 = context1.getBean("food1",Food.class);
        System.out.println(food1.toString());
        context1.registerShutdownHook();
        System.out.println();

        AbstractApplicationContext context2 = new AnnotationConfigApplicationContext(assignment8Config.class);
        context2.registerShutdownHook();
        Drink drink1 = context2.getBean("drink1",Drink.class);
        System.out.println(drink1.toString());

        AbstractApplicationContext context3 = new ClassPathXmlApplicationContext("file:src/main/java/assignments/assignment8/ByInterface/assignment8-config2.xml");
        Table table = context3.getBean("table", Table.class);
        context3.registerShutdownHook();
        System.out.println(table.toString());
    }
}
