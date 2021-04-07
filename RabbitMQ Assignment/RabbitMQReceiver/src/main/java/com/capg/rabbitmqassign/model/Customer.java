package com.capg.rabbitmqassign.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document
public class Customer implements Serializable{
    @Id
    String id;
    String firstName;
    String lastName;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "Customer First Name:"+firstName+" Last Name:"+lastName;
    }
}