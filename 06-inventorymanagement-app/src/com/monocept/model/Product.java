package com.monocept.model;

import java.io.Serializable;

public class Product implements Serializable{
    private String productID;
    private String productName;
    private String productDescription;
    private int quantity;
    private double price;

    public Product(String productID, String productName, String productDescription, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "\n" +
                "    productID='" + productID + '\'' + "\n" +
                "    productName='" + productName + '\'' + "\n" +
                "    productDescription='" + productDescription + '\'' + "\n" +
                "    quantity=" + quantity + "\n" +
                "    price=" + price + "\n" +
                '}';
    }

}
