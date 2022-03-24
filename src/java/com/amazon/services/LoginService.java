package com.amazon.services;

import com.amazon.model.User;
import com.amazon.security.CredentialManager;
import com.amazon.ui.SellerUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginService {

    private SellerUI sellerUI = new SellerUI();
    private Path pathFile = Paths.get("src/resources/Users.txt");

    public void loginService() throws IOException {

        CredentialManager credentialManager = new CredentialManager();

        Scanner console = new Scanner(System.in);
        System.out.println("Username: ");
        String loginUser = console.next();
        System.out.println("Password: ");
        String loginPassword = console.next();
        File oneFile = new File(String.valueOf(pathFile));
        BufferedReader br = new BufferedReader(new FileReader(oneFile));
        User user = credentialManager.login(loginUser, loginPassword);

        if (user != null) {
            System.out.println("Access Granted! Welcome," + loginUser + "!");

            //Va face trimitere la una din pagini, deocamdata e mesaj doar
            if (user.getRole().equals("buyer")) {
                System.out.println("Buyer page");
            } else {
                System.out.println("Seller page");
                sellerUI.run();
            }
        } else System.err.println("Wrong Username or Password! If you don't have an account please Sign Up!");

        br.close();
    }


}