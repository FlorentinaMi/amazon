package model;

import java.util.List;

public class Buyer extends User{
    private List<Product> orderList;

    public Buyer(int id, String userEmail, String password, String fullName, int phone, Address address) {
        super(id, userEmail, password, fullName,  phone, address);
    }

    public List<Product> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Product> orderList) {
        this.orderList = orderList;
    }
}
