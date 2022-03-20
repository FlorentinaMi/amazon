package com.amazon.services;

import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;

import java.io.IOException;
import java.util.Scanner;

public class AddProduct {

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

}
