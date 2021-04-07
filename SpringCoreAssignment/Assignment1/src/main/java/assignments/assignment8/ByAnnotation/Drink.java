package assignments.assignment8.ByAnnotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("drink1")
public class Drink {

    private String drinkName;
    private Integer drinkPrice;

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Integer getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(Integer drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    @PostConstruct
    public void initBean(){
        System.out.println();
        System.out.println("Inside Annotated PostConstruct DrinkBean()...");
        System.out.println("Setting Drink Name and Price...");
        this.setDrinkName("Coca-Cola");
        this.setDrinkPrice(45);
        System.out.println();
    }

    @PreDestroy
    public void DestroyBean(){
        System.out.println();
        System.out.println("Destroying DrinkBean in Annotated PreDestruct()..Bye");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkName='" + drinkName + '\'' +
                ", drinkPrice=" + drinkPrice +
                '}';
    }
}
