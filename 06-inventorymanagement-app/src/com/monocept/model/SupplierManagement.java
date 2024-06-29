package com.monocept.model;

import java.util.List;
import java.util.Scanner;

public class SupplierManagement {
    private Inventory inventory;
    private Scanner scanner;

    public SupplierManagement(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }

    public void addSupplier() {
        System.out.println("Enter the details of Supplier:");

        System.out.print("Enter the name of supplier: ");
        String supplierName = scanner.next();

        System.out.print("Enter the contact information: ");
        long contactInfo = scanner.nextLong();

        String supplierID = generateSupplierId();

        Supplier supplier = new Supplier(supplierID, supplierName, contactInfo);
        inventory.addSupplier(supplier);
        System.out.println("Supplier added successfully.");
    }

    public void updateSupplier() {
        System.out.print("Enter ID of the supplier to update: ");
        String supplierId = scanner.next();

        Supplier supplier = inventory.findSupplierById(supplierId);
        if (supplier == null) {
            System.out.println("Supplier with ID " + supplierId + " not found.");
            return;
        }

        System.out.println("Choose what to update:");
        System.out.println("1. Name");
        System.out.println("2. Contact Information");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                updateSupplierName(supplier);
                break;
            case 2:
                updateSupplierContactInfo(supplier);
                break;
            default:
                System.out.println("Invalid option. No changes made.");
        }
    }

    private void updateSupplierName(Supplier supplier) {
        System.out.print("Enter the updated name: ");
        String updatedName = scanner.next();
        supplier.setName(updatedName);
        System.out.println("Name updated successfully.");
    }

    private void updateSupplierContactInfo(Supplier supplier) {
        System.out.print("Enter the updated contact information: ");
        long updatedContactInfo = scanner.nextLong();
        supplier.setContactInformation(updatedContactInfo);
        System.out.println("Contact information updated successfully.");
    }

    public void deleteSupplier() {
        System.out.print("Enter ID of the supplier to delete: ");
        String supplierId = scanner.next();

        if (inventory.deleteSupplier(supplierId)) {
            System.out.println("Supplier deleted successfully.");
        } else {
            System.out.println("Supplier with ID " + supplierId + " not found.");
        }
    }

    public void viewAllSuppliers() {
        List<Supplier> suppliers = inventory.getAllSuppliers();

        if (suppliers.isEmpty()) {
            System.out.println("No suppliers available.");
            return;
        }

        System.out.println("List of all suppliers:");
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
            System.out.println();
        }
    }

    public void viewSupplierDetails() {
        System.out.print("Enter ID of the supplier to view details: ");
        String supplierId = scanner.next();

        Supplier supplier = inventory.findSupplierById(supplierId);
        if (supplier != null) {
            System.out.println("Supplier Details:");
            System.out.println(supplier);
        } else {
            System.out.println("Supplier with ID " + supplierId + " not found.");
        }
    }

    private String generateSupplierId() {
        return "SUPP-" + (int) (Math.random() * 1000);
    }

    public void closeScanner() {
        scanner.close();
    }
}
