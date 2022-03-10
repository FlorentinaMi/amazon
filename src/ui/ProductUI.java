package ui;

import model.Product;

import java.util.Scanner;

public class ProductUI {

    public static void searchProductField() {
        System.out.println("What's the product you are searching for...");
        Scanner in = new Scanner(System.in);
        String productName = in.nextLine();
    }


}
