package com.amazon.services;

import com.amazon.ui.SellerUI;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UpdateProduct {

    public void productUpdate() throws IOException {
        float price;
        int stock;
        String productName;
        String productDescription;

        Scanner console = new Scanner(System.in);
        ViewProduct.viewListProducts();
        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        System.out.print("Enter product ID you want to update : ");

        String pID = "Product ID: " + console.nextLine();

        String line = null;


        while (true) {
            File originalFile = new File(String.valueOf(filePath));
            BufferedReader br = new BufferedReader(new FileReader(originalFile));

            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            System.out.println(buildMenu());
            int option = console.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the new stock: ");
                    stockUpdate(console.nextInt(), null, br, pID,pw);
                    break;
                case 2:
                    System.out.println("Enter the new price: ");
                    price = console.nextFloat();
                    while ((line = br.readLine()) != null) {
                        String[] split = line.split("; ");
                        String idCode = split[0];
                        if (idCode.equals(pID)) {
                            String stockUpdate = split[4];
                            String prodNameUpdate = split[1];
                            String prodDescription = split[2];
                            String prodPrice = split[3];
                            if (prodPrice != null) {
                                float updatedPrice = price;
                                System.out.println("updated Price is: " + updatedPrice);
                                line = idCode + "; " + prodNameUpdate + "; " + prodDescription + "; " + "3. Product Price: " + updatedPrice + "; " + stockUpdate;
                            }

                        }
                        pw.println(line);
                        pw.flush();
                    }

                    break;
                case 3:
                    System.out.println("Enter the new product name: ");
                    productName = console.nextLine();
                    productName = console.nextLine();
                    while ((line = br.readLine()) != null) {
                        String[] split = line.split("; ");
                        String idCode = split[0];
                        if (idCode.equals(pID)) {
                            String stockUpdate = split[4];
                            String prodNameUpdate = split[1];
                            String prodDescription = split[2];
                            String prodPrice = split[3];
                            if (prodNameUpdate != null) {
                                String updatedName = productName;
                                System.out.println("Updated product name is: " + updatedName);
                                line = idCode + "; " + "1. Product Name: " + updatedName + "; " + prodDescription + "; " + prodPrice + "; " + stockUpdate;
                            }
                        }
                        pw.println(line);
                        pw.flush();
                    }

                    break;
                case 4:
                    System.out.println("Enter the new product description: ");
                    productDescription = console.nextLine();
                    productDescription = console.nextLine();
                    while ((line = br.readLine()) != null) {
                        String[] split = line.split("; ");
                        String idCode = split[0];
                        if (idCode.equals(pID)) {
                            String stockUpdate = split[4];
                            String prodNameUpdate = split[1];
                            String prodDescription = split[2];
                            String prodPrice = split[3];
                            if (prodDescription != null) {
                                String updatedDescription = productDescription;
                                System.out.println("Updated product description is: " + updatedDescription);
                                line = idCode + "; " + prodNameUpdate + "; " + "2. Product Description: " + updatedDescription + "; " + prodPrice + "; " + stockUpdate;
                            }

                        }
                        pw.println(line);
                        pw.flush();
                    }

                    break;
                case 5:
                    System.out.println("Go Back");
                    SellerUI sellerUI = new SellerUI();
                    sellerUI.run();
                    break;

            }
            br.close();
            pw.close();

            if (!originalFile.delete()) {
                System.out.println("Could not delete file");
            }

            if (!tempFile.renameTo(originalFile))
                System.out.println("Could not rename file");
        }


    }

    private static String buildMenu() {
        return "Please select what you want to update: \n"
                + "1. Update your stock \n"
                + "2. Update your Price \n"
                + "3. Update your product name \n"
                + "4. Update your product description \n"
                + "0. Go back to main menu \n";
    }

    private void stockUpdate (int stock, String line, BufferedReader br, String pID, PrintWriter pw) throws IOException {
        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String idCode = split[0];
            if (idCode.equals(pID)) {
                String stockUpdate = split[4];
                String prodNameUpdate = split[1];
                String prodDescription = split[2];
                String prodPrice = split[3];
                if (stockUpdate != null) {
                    int updatedStock = stock;
                    System.out.println("updated Stock is: " + updatedStock);
                    line = idCode + "; " + prodNameUpdate + "; " + prodDescription + "; " + prodPrice + "; " + "4. Product Stock: " + updatedStock;
                }

            }
            pw.println(line);
            pw.flush();
        }
    }


}





