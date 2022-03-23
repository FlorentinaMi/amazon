package com.amazon.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private int stock;

    public Product(String name, String description, float price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, String description, String price, String stock) {
        this.name = name;
        this.description = description;
        this.price = Float.parseFloat(price);
        this.stock = Integer.parseInt(stock);
    }

    public Product(int id, String name, String smallDescription, float price, int stock) {
        this.id = id;
        this.name = name;
        this.description = smallDescription;
        this.price = price;
        this.stock = stock;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
