package com.amazon.services;

import com.amazon.dao.UserDao;
import com.amazon.model.User;

import java.io.IOException;

public class UserService {
    private UserDao userDao = new UserDao();

    public void saveUser(User user) throws IOException {
        userDao.saveUser(user);
    }



}
