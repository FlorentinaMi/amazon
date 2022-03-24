package com.amazon.ui;

import com.amazon.services.ProductsService;

import java.io.IOException;
import java.util.Scanner;

public class SellerUI {

    public void run() throws IOException {

        ProductsService productsService = new ProductsService();
        LandingPageUI landingPageUI = new LandingPageUI();

        while (true) {
            System.out.println(buildMenuUI());
            Scanner console = new Scanner(System.in);
            System.out.println("Choose a number from the list: ");
            int option = console.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Add a product by completing the required information");
                    productsService.addProducts();
                    break;
                case 2:
                    System.out.println("Update your product");
                    productsService.productUpdate();
                    break;
                case 3:
                    System.out.println("Delete your product");
                    productsService.deleteProduct();
                    break;
                case 4:
                    System.out.println("View all your listed products");
                    productsService.viewListProducts();
                    break;
                case 0:
                    System.err.println("Log out!");
                    landingPageUI.selectOption();
                    break;
            }
        }
    }


    private static String buildMenuUI() {
        return "Welcome to AmaZon, you are logged in as a seller, let's sell something! \n"
                + "1. Add a product to sell \n"
                + "2. Update existing products for sell \n"
                + "3. Delete existing products for sell \n"
                + "4. View your listed products for sell \n"
                + "0. Exit \n";
    }
}