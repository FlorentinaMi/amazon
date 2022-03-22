package com.amazon.ui;

import com.amazon.services.ProductsService;

import java.io.IOException;
import java.util.Scanner;

public class SellerUI {

    public void run() throws IOException {

        while (true) {
            System.out.println(buildMenuUI());
            int option = readInt();
            switch (option) {
                case 1:
                    System.out.println("Add a product be completing the required information");
                    ProductsService productsService1 = new ProductsService();
                    productsService1.addProducts();
                    break;
                case 2:
                    System.out.println("Update your product");
                    ProductsService productsService2 = new ProductsService();
                    productsService2.productUpdate();
                    break;
                case 3:
                    System.out.println("Delete your product");
                    ProductsService productsService3 = new ProductsService();
                    productsService3.deleteProduct();
                    break;
                case 4:
                    System.out.println("View all your listed products");
                    ProductsService productsService4 = new ProductsService();
                    productsService4.viewListProducts();
                    break;
                case 0:
                    System.out.println("Log out!");
                    break;
            }
        }
    }

    private static int readInt() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        return keyboard.nextInt();
    }

    private static String buildMenuUI() {
        return "Welcome to Amazon, you are logged as a seller, let sell something! \n"
                + "1. Add a product to sell \n"
                + "2. Update existing products for selling \n"
                + "3. Delete existing products for selling \n"
                + "4. View your listed products for sell \n"
                + "0. Exit \n";
    }
}