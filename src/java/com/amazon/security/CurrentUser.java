package com.amazon.security;

import com.amazon.model.User;

public class CurrentUser {

    private static User currentUser;

    public static User get() {
        return currentUser;
    }

    public static void set(User currentUser) {
        CurrentUser.currentUser = currentUser;
    }

}
