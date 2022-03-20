package com.amazon.model;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

    public List<Product> Products;
    public Seller(String userEmail, String password, String address) {
        super(userEmail, password, address);
        Products = new ArrayList<Product>();
    }

}
