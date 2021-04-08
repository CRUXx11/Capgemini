package io.carwash.orders.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
    @Id
    private int id;
    private String Name;
    private String contact;
    private String carno;
    private String serviceneeded;
    private double price;

    public Order(int id,String name, String contact, String carno, String serviceneeded,Double price) {
        this.id=id;
        this.Name = name;
        this.contact = contact;
        this.carno = carno;
        this.serviceneeded = serviceneeded;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getServiceneeded() {
        return serviceneeded;
    }

    public void setServiceneeded(String serviceneeded) {
        this.serviceneeded = serviceneeded;
    }
}
