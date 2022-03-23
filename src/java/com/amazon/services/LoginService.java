package com.amazon.services;

import com.amazon.ui.SellerUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoginService {

    public String IDuser;
    SellerUI sellerUI = new SellerUI();

    public void loginService() throws IOException {

        Path pathFile = Paths.get("src/resources/Users.txt");

        Scanner console = new Scanner(System.in);
        System.out.println("Username: ");
        String loginUser = console.next();
        System.out.println("Password: ");
        String loginPassword = console.next();

        File oneFile = new File(String.valueOf(pathFile));
        BufferedReader br = new BufferedReader(new FileReader(oneFile));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(loginUser)) {
                String[] split = line.split(";");
                String IDData = split[0];
                String UsernameData = split[1];
                String PasswordData = split[2];
                String AccountTypeData = split[4];
                if (loginUser.equals(UsernameData) && loginPassword.equals(PasswordData)) {
                    System.out.println("Access Granted! Welcome," + loginUser + "!");
                    //Va face trimitere la una din pagini, deocamdata e mesaj doar
                    if (AccountTypeData.equals("buyer")) System.out.println("buyer page");
                    else {
                        System.out.println("seller page");
                        sellerUI.run();
                    }
                    //salvare ID user ptr atribuire la products, nu necesita afisare
                    IDuser = IDData;
                } else if (loginUser.equals(UsernameData)) {
                    System.out.println("Invalid Password! In case you forgot the password, please select 'Forgot Password' button");
                } else {
                    System.out.println("Invalid Username! If you don't have an account, please Sign up!");
                }
            }
        }
        br.close();
    }


}