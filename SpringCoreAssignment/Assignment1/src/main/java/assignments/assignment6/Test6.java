package assignments.assignment6;

import assignments.assignment6.classes.DatabaseConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {

    public static void main(String[] args){

        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
            DatabaseConnection connection = applicationContext.getBean("databaseConnection",DatabaseConnection.class);
            System.out.println();
            System.out.println("Driver Class: "+ connection.getDriverClassName());
            System.out.println("URL: "+connection.getUrl());
            System.out.println("UserName: "+connection.getUsername());
            System.out.println("Password: "+connection.getPassword());
        }
        catch (Exception e){
            System.out.println("Exception in Test6.java");
            e.printStackTrace();
        }
    }
}
