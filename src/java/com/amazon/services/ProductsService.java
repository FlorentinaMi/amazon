package com.amazon.services;

import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;
import com.amazon.ui.SellerUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ProductsService {

    private ProductDAO productDAO = new ProductDAO();
    Scanner console = new Scanner(System.in);

    public void addProducts() throws IOException {

        System.out.println("Product name:");
        String name = console.nextLine();

        System.out.println("Product description");
        String description = console.nextLine();

        System.out.println("Price");
        Float price = console.nextFloat();

        System.out.println("Stock");
        Integer stock = console.nextInt();

        Product product = new Product(name, description, price, stock);
        productDAO.saveProduct(product);
    }

    public void deleteProduct() throws IOException {

        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        viewListProducts();

        System.out.println("Enter product ID you want to delete: ");
        String pIDToRemove = "Product ID: " + console.nextLine();

        File originalFile = new File(String.valueOf(filePath));
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        File tempFile = new File("tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line;

        while ((line = br.readLine()) != null) {
            String[] split = line.split("; ");
            String productID = split[0];
            if (!productID.equals(pIDToRemove)) {
                pw.write(line + "\n");
            }
        }
        pw.close();
        br.close();

        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
        }

        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");
    }

    public void productUpdate() throws IOException {
        viewListProducts();
        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        System.out.print("Enter product ID you want to update : ");
        String pID = "Product ID: " + console.nextLine();

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
                    stockUpdate(console.nextInt(), br, pID, pw);
                    break;
                case 2:
                    System.out.println("Enter the new price: ");
                    priceUpdate(console.nextFloat(), br, pID, pw);
                    break;
                case 3:
                    System.out.println("Enter the new product name: ");
                    productNameUpdate(br, pID, pw);
                    break;
                case 4:
                    System.out.println("Enter the new product description: ");
                    productDescriptionUpdate(br, pID, pw);
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

    private String buildMenu() {
        return "Please select what you want to update: \n"
                + "1. Update your stock \n"
                + "2. Update your Price \n"
                + "3. Update your product name \n"
                + "4. Update your product description \n"
                + "0. Go back to main menu \n";
    }

    private void stockUpdate(int stock, BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
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

    private void priceUpdate(float price, BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
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
    }

    private void productNameUpdate(BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
        String productName = console.nextLine();
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
    }

    private void productDescriptionUpdate(BufferedReader br, String pID, PrintWriter pw) throws IOException {
        String line;
        String productDescription = console.nextLine();
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
    }

    public void viewListProducts() throws IOException {
        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            System.out.println(line + "\n");
        }
    }
}
