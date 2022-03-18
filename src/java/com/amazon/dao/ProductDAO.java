package com.amazon.dao;

import com.amazon.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class ProductDAO {

    public void saveProduct(Product product) throws IOException {
        Path filePath = Paths.get("src/resources/Products.txt");
        Files.write(filePath, productFileFormat(product).getBytes(), StandardOpenOption.APPEND);
        System.out.println(filePath + " Content was added");
    }

    public String productFileFormat(Product product) {
        return product.getName() + "\n" + product.getDescription() + "\n" + product.getPrice() + "\n" + product.getStock();
    }


}


