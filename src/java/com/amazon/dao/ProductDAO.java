package com.amazon.dao;

import com.amazon.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class ProductDAO {

    private Path productSequenceFile = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "ProductSequel.txt");

    public void saveProduct(Product product) throws IOException {
        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        Files.write(filePath, productFileFormat(product).getBytes(), StandardOpenOption.APPEND);
        System.out.println(filePath + " Content was added");
    }

    public String productFileFormat(Product product) throws IOException {
        return "\n" + "Product ID: A" + getNewId() + product.getId() + "; " + "1. Product Name: " + product.getName() + "; " + "2. Product Description: " + product.getDescription() + "; " + "3. Product Price: " + product.getPrice() + "; " + "4. Product Stock: " + product.getStock();
    }

    public String getNewId() throws IOException {
        String newId;
        String oldId = Files.readString(productSequenceFile);
        newId = String.valueOf(Integer.parseInt(oldId) + 1);
        Files.write(productSequenceFile, newId.getBytes(), StandardOpenOption.WRITE);
        return newId;
    }

}


