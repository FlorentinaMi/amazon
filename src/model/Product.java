package model;

public class Product {
    private int id;
    private String name;
    private String description;
    private float price;

    public Product(int id, String name, String smallDescription, float price) {
        this.id = id;
        this.name = name;
        this.description = smallDescription;
        this.price = price;

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

}
