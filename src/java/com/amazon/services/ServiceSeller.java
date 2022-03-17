package com.amazon.services;

import java.util.Scanner;

public class ServiceSeller {

    public static String name;
    public static String description;
    public static String price;
    public static String stock;

    public static byte[] addProducts() {
        Scanner input = new Scanner(System.in);
        System.out.println("Product name:");
        String name = input.nextLine();

        System.out.println("Product description");
        String description = input.nextLine();

        System.out.println("Price");
        String price = input.nextLine();

        System.out.println("Stock");
        String stock = input.nextLine();
        input.close();

        return new byte[0];
    }


    public static void viewProducts() {
    }

    public static void deleteProducts() {
    }

    public static void updateProducts() {
    }

}
