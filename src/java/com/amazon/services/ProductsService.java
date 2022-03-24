package com.amazon.services;

import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;
import com.amazon.security.CurrentUser;
import com.amazon.ui.SellerUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ProductsService {

    private Path filePath = Paths.get("src/resources/Products.txt");
    private ProductDAO productDAO = new ProductDAO();
    private String accountID = String.valueOf(CurrentUser.get().getId());
    Scanner console = new Scanner(System.in);

    public void addProducts() throws IOException {
        Scanner input =  new Scanner(System.in);
        System.out.println("Product name:");
        String name = input.nextLine();

        System.out.println("Product description");
        String description = input.nextLine();

        System.out.println("Price");
        Float price = input.nextFloat();

        System.out.println("Stock");
        Integer stock = input.nextInt();

        Product product = new Product(name, description, price, stock);
        productDAO.saveProduct(product);
    }

    public void deleteProduct() throws IOException {

        viewListProducts();

        System.out.println("Enter product ID you want to delete: ");
        String pIDToRemove = console.nextLine();

        File originalFile = new File(String.valueOf(filePath));
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File tempFile = new File("tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line;
        boolean check = false;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String productID = split[0];
            String fileAccountId = split[1];
            boolean condition = fileAccountId.equals(accountID) && productID.equals(pIDToRemove);
            if (!condition) {
                pw.write(line + "\n");
            }
            if (condition) {
                System.out.println("The product is removed.");
                check = true;
            }
        }
        if (!check) {
            System.err.println("The Product ID could not be found. Please try again.");
        }
        pw.close();
        br.close();

        if (!originalFile.delete()) {
            System.out.println("Could not delete file.");
        }

        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file.");
    }

    public void productUpdate() throws IOException {
        viewListProducts();
        System.out.print("Enter product ID you want to update : ");
        String pID = console.nextLine();

        while (true) {
            File originalFile = new File(String.valueOf(filePath));
            BufferedReader br = new BufferedReader(new FileReader(originalFile));

            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            System.out.println(buildProductUpdateMenu());
            int option = console.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the new product name: ");
                    productNameUpdate(br, pID, pw);
                    break;
                case 2:
                    System.out.println("Enter the new product description: ");
                    productDescriptionUpdate(br, pID, pw);
                    break;
                case 3:
                    System.out.println("Enter the new price: ");
                    priceUpdate(console.nextFloat(), br, pID, pw);
                    break;
                case 4:
                    System.out.println("Enter the new stock: ");
                    stockUpdate(console.nextInt(), br, pID, pw);
                    break;
                case 0:
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

    private String buildProductUpdateMenu() {
        return "Please select what you want to update: \n"
                + "1. Update your product name \n"
                + "2. Update your product description \n"
                + "3. Update your price \n"
                + "4. Update your stock \n"
                + "0. Go back to the main menu \n";
    }

    private void productNameUpdate(BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
        String productName = console.nextLine();
        productName = console.nextLine();
        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String idProductCode = split[0];
            String lineUserId = split[1];
            boolean condition = lineUserId.equals(accountID) && idProductCode.equals(pID);
            if (condition) {
                String prodNameUpdate = split[2];
                String prodDescription = split[3];
                String prodPrice = split[4];
                String stockUpdate = split[5];
                if (prodNameUpdate != null) {
                    String updatedName = productName;
                    System.out.println("Updated product name is: " + updatedName);
                    line = idProductCode + "; " + lineUserId + "; " + updatedName + "; " + prodDescription + "; " + prodPrice + "; " + stockUpdate;
                }
            }
            pw.println(line);
            pw.flush();
        }
    }

    private void productDescriptionUpdate(BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
        String productDescription = console.nextLine();
        productDescription = console.nextLine();
        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String idProductCode = split[0];
            String lineUserId = split[1];
            boolean condition = lineUserId.equals(accountID) && idProductCode.equals(pID);
            if (condition) {
                String prodNameUpdate = split[2];
                String prodDescription = split[3];
                String prodPrice = split[4];
                String stockUpdate = split[5];
                if (prodDescription != null) {
                    String updatedDescription = productDescription;
                    System.out.println("Updated product description is: " + updatedDescription);
                    line = idProductCode + "; " + lineUserId + "; " + prodNameUpdate + "; " + updatedDescription + "; " + prodPrice + "; " + stockUpdate;
                }

            }
            pw.println(line);
            pw.flush();
        }
    }

    private void priceUpdate(float price, BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String idProductCode = split[0];
            String lineUserId = split[1];
            boolean condition = lineUserId.equals(accountID) && idProductCode.equals(pID);
            if (condition) {
                String prodNameUpdate = split[2];
                String prodDescription = split[3];
                String prodPrice = split[4];
                String stockUpdate = split[5];
                if (prodPrice != null) {
                    float updatedPrice = price;
                    System.out.println("updated Price is: " + updatedPrice);
                    line = idProductCode + "; "+ lineUserId + "; " + prodNameUpdate + "; " + prodDescription + "; " + updatedPrice + "; " + stockUpdate;
                }

            }
            pw.println(line);
            pw.flush();
        }
    }

    private void stockUpdate(int stock, BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String idProductCode = split[0];
            String lineUserId = split[1];
            boolean condition = lineUserId.equals(accountID) && idProductCode.equals(pID);
            if (condition) {
                String prodNameUpdate = split[2];
                String prodDescription = split[3];
                String prodPrice = split[4];
                String stockUpdate = split[5];
                if (stockUpdate != null) {
                    int updatedStock = stock;
                    System.out.println("updated Stock is: " + updatedStock);
                    line = idProductCode + "; " + lineUserId + "; " + prodNameUpdate + "; " + prodDescription + "; " + prodPrice + "; " + updatedStock;
                }

            }
            pw.println(line);
            pw.flush();
        }
    }


    public void viewListProducts() throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        String fileUserID = String.valueOf(CurrentUser.get().getId());
        for (String line : lines) {
            String[] split = line.split("; ");
            String idProduct = split[0];
            String userId = split[1];
            String prodNameUpdate = split[2];
            String prodDescription = split[3];
            String prodPrice = split[4];
            String stockUpdate = split[5];
            if (userId.equals(fileUserID))
                System.out.println("Product ID: " + idProduct + " | " + "1. Product Name: " + prodNameUpdate + " | " + "2. Product Description: " + prodDescription + " | " + "3. Product Price: " + prodPrice + " | " + "4. Product Stock: " + stockUpdate);
        }
    }
}
