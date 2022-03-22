package com.amazon.services;

import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;

import java.io.IOException;

public class ProductsService {

    private ProductDAO productDAO = new ProductDAO();

    public void saveProduct(Product product) throws IOException {

        productDAO.saveProduct(product);

    }

}
