package model;

import java.util.List;

public class Seller extends User {
    private List<Product> productList;

    public Seller(int id, String userEmail, String password, String fullName, int phone, Address address) {
        super(id, userEmail, password, fullName, phone, address);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
