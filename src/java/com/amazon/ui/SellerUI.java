package com.amazon.ui;

import com.amazon.services.ServiceSeller;

import java.io.IOException;
import java.util.Scanner;

public class SellerUI {

    // public static int Products_Add = 1;
    // public static int Product_Update = 2;
    // public static int Product_Delete = 3;
    // static int Product_View = 4;

public void run() throws IOException {

    while (true) {
        System.out.println(buildMenu());
        int option = readInt();
        switch (option) {
            case 1:
                System.out.println("Add a product be completing the required information");
                //ServiceSeller.addProducts();
                break;
            case 2:
                System.out.println("Update your product");
                ServiceSeller.updateProducts();
                break;
            case 3:
                System.out.println("Delete your product");
                ServiceSeller.deleteProducts();
                break;
            case 4:
                System.out.println("View all your products");
                ServiceSeller.viewProducts();
                break;
            case 0:
                System.out.println("Exit!");
                break;

            }


        }

    }

    private static int readInt() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        return keyboard.nextInt();
    }

    private static String buildMenu() {
        return "Welcome to Amazon, you are logged as a seller, let sell something! \n"
                + "1. Add a product to sell \n"
                + "2. Update existing products for selling \n"
                + "3. Delete existing products for selling \n"
                + "4. View your products for sell \n"
                + "0. Exit \n";
    }
}