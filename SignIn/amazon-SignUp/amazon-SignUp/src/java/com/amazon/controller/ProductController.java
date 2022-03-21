package com.amazon.controller;

import com.amazon.model.Product;

public class ProductController {

    public void saveProduct (String name, String description, String price, String stock){

        validateText(name);
        validateText(description);
        validateText(price);
        validateText(stock);

        Product product = new Product(name, description,convertToNumber(price), convertToNumber(stock));

    }
    // view
    // update
    // delete

    private void validateText (String text) {
        // if empty or null, throw exception

    }

    private int convertToNumber(String text){
        return Integer.parseInt(text);
        // handle parseInt exception
    }
}
