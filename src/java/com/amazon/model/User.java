package com.amazon.model;

public abstract class User {
    private int id;
    private String userEmail;
    private String password;
    private String address;

    public User(String userEmail, String password, String address) {
        this.userEmail = userEmail;
        this.password = password;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {return userEmail;}

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
