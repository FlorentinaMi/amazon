package com.amazon;

import com.amazon.ui.LandingPageUI;
import com.amazon.ui.SellerUI;

import java.io.IOException;

public class AmazonApp {

    public static void main(String[] args) throws IOException {
        LandingPageUI landingPageUI = new LandingPageUI();
        landingPageUI.startUI();

        SellerUI sellerUI = new SellerUI();
        sellerUI.run();

    }

}
