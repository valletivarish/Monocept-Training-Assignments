package com.monocept.model;

import java.util.List;
import java.util.Scanner;
import com.monocept.exceptions.DuplicateProduct;
import com.monocept.exceptions.InvalidProductId;

public class ProductManagement {
    private Inventory inventory;
    private Scanner scanner;

    public ProductManagement(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }

    public void addProduct() {
        System.out.println("Enter the details of Product:");

        System.out.print("Enter the name of product: ");
        String productName = scanner.next();
        System.out.print("Enter the description :");
        String description = scanner.next();

        System.out.print("Enter the price of product: ");
        double price = scanner.nextDouble();

        System.out.print("Enter the initial stock quantity: ");
        int initialStock = scanner.nextInt();

        String productId = generateProductId();

        Product product = new Product(productId, productName, description, initialStock, price);
        try {
            inventory.addProduct(product);
            System.out.println("Product added successfully.");
        } catch (DuplicateProduct e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateProduct() {
        System.out.print("Enter ID of the product to update: ");
        String productId = scanner.next();

        Product product = inventory.findProductById(productId);
        if (product == null) {
        	throw new InvalidProductId();
        }

        System.out.println("Choose what to update:");
        System.out.println("1. Name");
        System.out.println("2. Price");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                updateProductName(product);
                break;
            case 2:
                updateProductPrice(product);
                break;
            default:
                System.out.println("Invalid option. No changes made.");
        }
    }

    private void updateProductName(Product product) {
        System.out.print("Enter the updated name: ");
        String updatedName = scanner.next();
        product.setProductName(updatedName);
        System.out.println("Name updated successfully.");
    }

    private void updateProductPrice(Product product) {
        System.out.print("Enter the updated price: ");
        double updatedPrice = scanner.nextDouble();
        product.setPrice(updatedPrice);
        System.out.println("Price updated successfully.");
    }

    public void deleteProduct() {
        System.out.print("Enter ID of the product to delete: ");
        String productId = scanner.next();

        if (inventory.deleteProduct(productId)) {
            System.out.println("Product deleted successfully.");
            return;
        } 
        throw new InvalidProductId();
    }

    public void viewAllProducts() {
        List<Product> products = inventory.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("List of all products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void viewProductDetails() {
        System.out.print("Enter ID of the product to view details: ");
        String productId = scanner.next();

        Product product = inventory.findProductById(productId);
        if (product != null) {
            System.out.println("Product Details:");
            System.out.println(product);
            return;
        } 
        throw new InvalidProductId();
    }

    private String generateProductId() {
        return "PROD-" + (int) (Math.random() * 1000);
    }

}
