package com.amazon.services;

import java.util.Scanner;

public class ServiceSeller {

    public static void addProducts(){
        Scanner input = new Scanner(System.in);
        System.out.println("Product name:");
        String name = input.nextLine();

        System.out.println("Product description");
        String description = input.nextLine();

        System.out.println("");
        String price = input.nextLine();

        System.out.println("");
        String stock = input.nextLine();
        input.close();
    }
    public static void viewProducts() {
    }

    public static void deleteProducts() {
    }

    public static void updateProducts() {
    }

}
