package assignments.assignment8.ByXML;

public class Food {

    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void beanInit(){
        System.out.println();
        System.out.println("Inside FoodBean Initialiazation Method via XML ...");
        System.out.println("Setting name and price ");
        this.setName("Samosa");
        this.setPrice(20);
        System.out.println();
    }

    public void beanDestroy() {
        System.out.println();
        System.out.println("Destroyin FoodBean Now .. beanDestroy() via XML!!");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
