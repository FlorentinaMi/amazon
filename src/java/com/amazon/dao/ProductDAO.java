package com.amazon.dao;

import com.amazon.services.ServiceSeller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductDAO {

    public static void saveProduct() throws IOException {
        Path ioChapter = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        Files.write(ioChapter, ServiceSeller.addProducts());
        System.out.println(ioChapter + " Content was added");
    }

}
