package com.amazon.dao;

import com.amazon.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.write;

public class UserDao {
    private Path pathFile = Paths.get("src/resources/Users.txt");
    private Path userSequenceFile = Paths.get("src/resources/UserSequence.txt");

    public void saveUser(User user) throws IOException {
        write(pathFile, userFileFormat(user).getBytes(), StandardOpenOption.APPEND);
        System.out.println(pathFile + "The user was successfully added!");
    }

    public String userFileFormat(User user) throws IOException {
        return getNewId() + ";" + user.getUserEmail() + ";" + user.getPassword() + ";"
                + user.getAddress() + ";" + user.getRole() + "\n";
    }

    public String getNewId() throws IOException {
        String newId;
        String oldId = Files.readString(userSequenceFile);
        newId = String.valueOf(Integer.parseInt(oldId) + 1);
        Files.write(userSequenceFile, newId.getBytes(), StandardOpenOption.WRITE);
        return newId;
    }


}
