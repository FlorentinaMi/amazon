package com.amazon.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ViewProduct {

    public static void viewListProducts() throws IOException {
        Path filePath = Paths.get("C:", "Users", "Dani", "Desktop", "EchipaAmazon", "amazon", "src", "resources", "Products.txt");
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
