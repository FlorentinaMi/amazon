package com.amazon.services;

import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProductsService {

    private ProductDAO productDAO = new ProductDAO();

    public void addProducts() throws IOException {
        Scanner input = new Scanner(System.in);
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

        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        ViewProduct.viewListProducts();
        Scanner console = new Scanner(System.in);

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

}
