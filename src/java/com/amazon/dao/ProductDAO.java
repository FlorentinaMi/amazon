package com.amazon.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.amazon.services.ServiceSeller.*;

public class ProductDAO {

    public static void saveProduct() throws IOException {
        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        Files.write(filePath, name, description, price, stock);
        System.out.println(filePath + " Content was added");
    }

    }


