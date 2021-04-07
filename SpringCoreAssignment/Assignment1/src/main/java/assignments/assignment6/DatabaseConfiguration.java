package assignments.assignment6;

import assignments.assignment6.classes.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:src/main/java/assignments/assignment6/dbConfig.properties")
@ComponentScan(basePackages = "assignments.assignment6")
public class DatabaseConfiguration {

    @Autowired
    private Environment environment;

    @Bean(name = "databaseConnection")
    public DatabaseConnection getDatabaseConnection(){
        DatabaseConnection connection = new DatabaseConnection();
        connection.setDriverClassName(environment.getProperty("driverClassName"));
        connection.setUrl(environment.getProperty("url"));
        connection.setUsername(environment.getProperty("username"));
        connection.setPassword(environment.getProperty("password"));
        return connection;
    }

}
