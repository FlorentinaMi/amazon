package com.amazon;

import com.amazon.services.LoginService;
import com.amazon.ui.LandingPageUI;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class AmazonApp {

    public static void main(String[] args) throws IOException {
       // LandingPageUI landingPageUI = new LandingPageUI();
      // landingPageUI.startUI();
        LoginService loginService = new LoginService();
        loginService.loginService();
    }
}
