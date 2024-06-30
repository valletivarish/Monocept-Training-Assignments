package com.monocept.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable{
    private String transactionID;
    private String productID;
    private String type;
    private int quantity;
    private LocalDateTime date;

    public Transaction(String transactionID, String productID, String type, int quantity, LocalDateTime date) {
        this.transactionID = transactionID;
        this.productID = productID;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy. HH:mm");
        String formattedDate = date.format(formatter);

        return "Transaction{" + "\n" +
                "    transactionID='" + transactionID + "',\n" +
                "    productID='" + productID + "',\n" +
                "    type='" + type + "',\n" +
                "    quantity=" + quantity + ",\n" +
                "    date=" + formattedDate + "\n" +
                "}";
    }
}
