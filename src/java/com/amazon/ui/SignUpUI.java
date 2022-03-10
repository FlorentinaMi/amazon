package com.amazon.ui;

import com.amazon.model.Buyer;
import com.amazon.model.Seller;
import com.amazon.model.User;
import com.amazon.services.UserService;

import java.util.Scanner;

public class SignUpUI {
    private UserService userService = new UserService();
    Scanner keyboardScanner = new Scanner(System.in);

    //logica de cules date
    public void startUI() {
        showWelcomeMessage();
        User user = getUserInfo();
        // save to db;
    }


    private void showWelcomeMessage() {
        System.out.println("Sign UP Form:");
    }

    private User getUserInfo() {
        String email = getEmail();
        String password = getPassword();
        String address = getAddress();
        String role = getRole();
        while (!role.equals("seller") && !role.equals("buyer")) {
            System.out.println("Not a valid role!");
            role = getRole();
        }
        if (role.equals("seller")) {
            Seller seller = new Seller(email, password, address);
            return seller;
        } else {
            Buyer buyer = new Buyer(email, password, address);
            return buyer;
        }
    }

    private String getRole() {
        System.out.println("What do you want to be when you grow up? ");
        return keyboardScanner.next();
    }

    public String getEmail() {
        System.out.println("Enter your Email:");
        return keyboardScanner.next();
    }

    public String getPassword() {
        System.out.println("Enter your password:");
        return keyboardScanner.next();
    }

    public String getAddress() {
        System.out.println("Enter your address:");
        return keyboardScanner.next();
    }
}
