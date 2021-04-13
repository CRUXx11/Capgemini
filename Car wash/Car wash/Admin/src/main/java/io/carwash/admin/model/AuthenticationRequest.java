package io.carwash.admin.model;

public class AuthenticationRequest {
    String name;
    String password;

    public AuthenticationRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public AuthenticationRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
