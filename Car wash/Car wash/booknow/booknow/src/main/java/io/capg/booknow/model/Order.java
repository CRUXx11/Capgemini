package io.capg.booknow.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document
public class Order {
    @Id
    private int id;
    private String Name;
    private String contact;
    private String carno;
    private String serviceneeded;

    public Order(String name, String contact, String carno, String serviceneeded) {
        Name = name;
        this.contact = contact;
        this.carno = carno;
        this.serviceneeded = serviceneeded;
    }

    public Order() {
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
