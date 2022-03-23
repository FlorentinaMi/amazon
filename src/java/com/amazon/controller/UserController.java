package com.amazon.controller;

import com.amazon.exceptions.UserInputException;
import com.amazon.model.Buyer;
import com.amazon.model.Seller;
import com.amazon.services.UserService;

import java.io.IOException;

public class UserController {

    private UserService userService = new UserService();

    public void saveUser(String email, String password, String address, String role) throws UserInputException, IOException {
        checkInput(email);
        checkInput(password);
        checkInput(address);
        if (role.equals("seller")) {
            Seller seller = new Seller(email, password, address, role);
            userService.saveUser(seller);
        } else {
            Buyer buyer = new Buyer(email, password, address, role);
            userService.saveUser(buyer);
        }
    }

    public void checkInput(String text) throws UserInputException {
        if (text.isEmpty()) {
            throw new UserInputException();
        }
    }


}
