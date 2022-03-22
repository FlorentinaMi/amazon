package com.amazon;

import com.amazon.ui.ProductUI;
import com.amazon.ui.SellerUI;

import java.io.IOException;

public class AmazonApp {

    public static ProductUI product;

    public static void main(String[] args) throws IOException {

        SellerUI sellerUI = new SellerUI();
        sellerUI.run();

    }

}
