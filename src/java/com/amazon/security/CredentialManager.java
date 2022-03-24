package com.amazon.security;

import com.amazon.model.Seller;
import com.amazon.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CredentialManager {

    private Path pathFile = Paths.get("src/resources/Users.txt");

    /**
     * @return if the login is successful, the user object. Else it returns null.
     */
    public User login (String username, String password) throws IOException {
        File oneFile = new File(String.valueOf(pathFile));
        BufferedReader br = new BufferedReader(new FileReader(oneFile));

        String line;
        while ((line = br.readLine()) != null) {

            if (line.contains(username)) {
                String[] split = line.split(";");
                String IDData = split[0];
                String UsernameData = split[1];
                String PasswordData = split[2];
                String address = split[3];
                String accountTypeData = split[4];

                if (username.equals(UsernameData) && password.equals(PasswordData)) {
                    Seller seller = new Seller(Integer.parseInt(IDData), username, password, address, accountTypeData);
                    CurrentUser.set(seller);
                    return seller;
                }
            }
        }

        br.close();
        return null;

    }
}
