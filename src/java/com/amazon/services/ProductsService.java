package com.amazon.services;

import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;

public class ProductsService {

    private ProductDAO productDAO = new ProductDAO();

    public void saveProduct(Product product) {

        productDAO.saveProduct(product);

    }

}
