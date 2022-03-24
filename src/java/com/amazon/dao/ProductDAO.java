package com.amazon.dao;

import com.amazon.model.Product;
import com.amazon.security.CurrentUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class ProductDAO {

    private Path filePath = Paths.get("src/resources/Products.txt");
    private Path productSequenceFile = Paths.get("src/resources/ProductSequence.txt");

    public void saveProduct(Product product) throws IOException {
        Files.write(filePath, productFileFormat(product).getBytes(), StandardOpenOption.APPEND);
        System.out.println(filePath + " Content was added");
    }

    public String productFileFormat(Product product) throws IOException {
        return "\n"  + getNewProductId() + "; " + CurrentUser.get().getId() + "; " + product.getName() + "; " + product.getDescription() + "; " + product.getPrice() + "; " + product.getStock();
    }

    public String getNewProductId() throws IOException {
        String newId;
        String oldId = Files.readString(productSequenceFile);
        newId = String.valueOf(Integer.parseInt(oldId) + 1);
        Files.write(productSequenceFile, newId.getBytes(), StandardOpenOption.WRITE);
        return newId;
    }

}


