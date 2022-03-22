package com.amazon.ui;

import java.io.IOException;
import java.util.Scanner;

public class LandingPageUI {
    private Scanner keyboardInput = new Scanner(System.in);
    //    private LoginPageUI loginPageUI = new LoginPageUI();
    private SignUpUI signUpUI = new SignUpUI();

    public void startUI() throws IOException {
        System.out.println("Welcome to the landing page!");
        while (true) {
            selectOption();
        }
    }

    public void selectOption() throws IOException {
        String userInput = "";
        while (!userInput.equals("1") && !userInput.equals("2")) {
            System.out.println("Select options by number: 1. Login, 2. SignUp");
            userInput = keyboardInput.next();
            switch (userInput) {
                case "1":
//                    loginPageUI.startUI();
                    break;
                case "2":
                    signUpUI.startUI();
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        }
    }
}
