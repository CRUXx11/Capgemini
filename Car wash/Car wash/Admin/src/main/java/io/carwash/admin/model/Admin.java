package io.carwash.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "customer")
public class Admin implements Serializable {
    @Id
    String id;
    String Name;
    String password;
    String email;
    String contact;

    public Admin(String name, String password, String email, String contact) {
        this.Name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public Admin() {
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
