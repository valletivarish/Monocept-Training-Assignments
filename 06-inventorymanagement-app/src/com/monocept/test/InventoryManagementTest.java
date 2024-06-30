package com.monocept.test;

import java.io.IOException;
import java.util.Scanner;

import com.monocept.exceptions.DuplicateProduct;
import com.monocept.exceptions.DuplicateSuppliers;
import com.monocept.exceptions.InsufficientStock;
import com.monocept.exceptions.InvalidProductId;
import com.monocept.model.Inventory;
import com.monocept.model.ProductManagement;
import com.monocept.model.SupplierManagement;
import com.monocept.model.TransactionManagement;

public class InventoryManagementTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Inventory inventory = new Inventory();
        ProductManagement productManagement = new ProductManagement(inventory);
        SupplierManagement supplierManagement = new SupplierManagement(inventory);
        TransactionManagement transactionManagement = new TransactionManagement(inventory);

        try {
            boolean exit = false;
            while (!exit) {
                System.out.println("Welcome to the Inventory Management System");
                System.out.println("1. Product Management");
                System.out.println("2. Supplier Management");
                System.out.println("3. Transaction Management");
                System.out.println("4. Load Data");
                System.out.println("5. Save Data");
                System.out.println("6. Generate Reports");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        productManagement(productManagement);
                        break;
                    case 2:
                        supplierManagement(supplierManagement);
                        break;
                    case 3:
                        transactionManagement(transactionManagement);
                        break;
                    case 4:
                        loadData(inventory);
                        break;
                    case 5:
                        saveData(inventory);
                        break;
                    case 6:
                        generateReports(inventory);
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            }
        } catch (InvalidProductId e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientStock e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DuplicateProduct e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DuplicateSuppliers e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }

    private static void generateReports(Inventory inventory) {
        inventory.generateReports();
    }

    private static void saveData(Inventory inventory) throws IOException {
        inventory.saveData();
    }

    private static void loadData(Inventory inventory) throws ClassNotFoundException, IOException {
        inventory.loadData();
    }

    private static void transactionManagement(TransactionManagement transactionManagement) {
        System.out.println("Transaction Management Menu: ");
        System.out.println("1. Add Stock");
        System.out.println("2. Remove Stock");
        System.out.println("3. View Transaction History");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                transactionManagement.addStock();
                break;
            case 2:
                transactionManagement.removeStock();
                break;
            case 3:
                transactionManagement.viewTransactionHistory();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
    }

    private static void supplierManagement(SupplierManagement supplierManagement) {
        System.out.println("Supplier Management Menu:");
        System.out.println("1. Add Supplier");
        System.out.println("2. Update Supplier");
        System.out.println("3. Delete Supplier");
        System.out.println("4. View Supplier Details");
        System.out.println("5. View All Suppliers");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                supplierManagement.addSupplier();
                break;
            case 2:
                supplierManagement.updateSupplier();
                break;
            case 3:
                supplierManagement.deleteSupplier();
                break;
            case 4:
                supplierManagement.viewSupplierDetails();
                break;
            case 5:
                supplierManagement.viewAllSuppliers();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }

    private static void productManagement(ProductManagement productManagement) {
        System.out.println("Product Management Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. View Product Details");
        System.out.println("5. View All Products");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                productManagement.addProduct();
                break;
            case 2:
                productManagement.updateProduct();
                break;
            case 3:
                productManagement.deleteProduct();
                break;
            case 4:
                productManagement.viewProductDetails();
                break;
            case 5:
                productManagement.viewAllProducts();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }
}