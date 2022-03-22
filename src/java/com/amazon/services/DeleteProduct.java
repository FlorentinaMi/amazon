package com.amazon.services;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DeleteProduct {

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


