package assignments.assignment10;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextImpl implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Employee employee = applicationContext.getBean("employee1",Employee.class);
        System.out.println("Called through ApplicationContextAware...");
        System.out.println(employee.toString());
    }
}
