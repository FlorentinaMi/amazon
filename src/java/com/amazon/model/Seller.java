package com.amazon.model;

public class Seller extends User {

    public Seller(String userEmail, String password, String address, String role) {
        super(userEmail, password, address, role);
    }

    public Seller(int idData, String username, String password, String address, String accountTypeData) {
        super(idData, username, password, address, accountTypeData);
    }

}
