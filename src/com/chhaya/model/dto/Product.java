package com.chhaya.model.dto;

import java.util.Date;

public class Product {

    private int id;
    private String name;
    private int qty;
    private double price;
    private Date importedDate;
    private Category category;

    public Product(int id, String name, int qty, double price, Date importedDate, Category category) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.importedDate = importedDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(Date importedDate) {
        this.importedDate = importedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", importedDate=" + importedDate +
                ", category=" + category +
                '}';
    }

}
