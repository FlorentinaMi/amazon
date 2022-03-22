package com.amazon.ui;

import com.amazon.controller.UserController;
import com.amazon.exceptions.UserInputException;

import java.io.IOException;
import java.util.Scanner;


public class SignUpUI {
    private Scanner keyboardScanner = new Scanner(System.in);
    private UserController userController = new UserController();

    public void startUI() throws IOException {
        showWelcomeMessage();
        saveUser();
    }

    private void showWelcomeMessage() {
        System.out.println("Welcome to Amazon: Please fill in the data for your new account in the following fields!");
    }

    public void saveUser() throws IOException {
        String email = getEmail();
        String password = getPassword();
        String address = getAddress();
        String role = getRole();
        while (!role.equals("seller") && !role.equals("buyer")) {
            System.out.println("Not a valid role!");
            role = getRole();
        }
        try {
            userController.saveUser(email, password, address, role);
        } catch (UserInputException ex){
            System.out.println("Invalid input, user not saved!");
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
