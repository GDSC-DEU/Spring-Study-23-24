package com.example.demo.user;

public class User {
    // Properties
    private String name;
    private String email;
    private String password;


    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Methods
    @Override
    public String toString() {
        return "Name: " + name + " Email: " + email + " Password: " + password;
    }
}
