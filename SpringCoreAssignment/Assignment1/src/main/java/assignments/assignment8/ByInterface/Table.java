package assignments.assignment8.ByInterface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("table")
public class Table implements InitializingBean, DisposableBean {
     private String tableType;
     private Integer tablePrice;

    public Table() {
        super();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println();
        System.out.println("TableBean is getting destroyed");
        System.out.println("Inside Destroy Method of TableBean ..Bye");
        System.out.println();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println();
        System.out.println("TableBean Initialized..");
        System.out.println("Inside Initializing method()..setting bean variables..");
        this.tablePrice = 123300;
        this.tableType = "Wooden";
        System.out.println();
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableType='" + tableType + '\'' +
                ", tablePrice=" + tablePrice +
                '}';
    }
}
