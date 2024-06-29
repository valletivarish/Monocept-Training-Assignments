package com.monocept.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.monocept.exceptions.InsufficientStock;

public class TransactionManagement {
    private Inventory inventory;
    private Scanner scanner;
    private ExecutorService executorService;

    public TransactionManagement(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public void addStock() {
        System.out.print("Enter the product Id : ");
        String productId = scanner.next();

        Product product = inventory.findProductById(productId);
        if (product != null) {
            System.out.println(product.getProductName() + " found");
            System.out.print("How much quantity do you want to add : ");
            int quantity = scanner.nextInt();
            executorService.submit(() -> {
                synchronized (product) {
                    product.setQuantity(product.getQuantity() + quantity);

                    Transaction transaction = new Transaction(generateTransactionId(), product.getProductID(), "Added stock", quantity, LocalDateTime.now());
                    inventory.addTransaction(transaction);
                }
            });
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("No product found.");
        }
    }

    public void removeStock() {
        System.out.print("Enter the product Id : ");
        String productId = scanner.next();

        Product product = inventory.findProductById(productId);
        if (product != null) {
            System.out.println(product.getProductName() + " found");
            System.out.print("How much quantity do you want to remove : ");
            int quantity = scanner.nextInt();
            if (product.getQuantity() >= quantity) {
                executorService.submit(() -> {
                    synchronized (product) {
                        product.setQuantity(product.getQuantity() - quantity);

                        Transaction transaction = new Transaction(generateTransactionId(), product.getProductID(), "Removed Stock", quantity, LocalDateTime.now());
                        inventory.addTransaction(transaction);
                    }
                });
                System.out.println("Stock updated successfully.");
            } else {
                try {
                    throw new InsufficientStock();
                } catch (InsufficientStock e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("No product found.");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History : ");
        List<Transaction> transactions = inventory.getTransactions();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
                System.out.println();
            }
        }
    }

    private String generateTransactionId() {
        return "TRX-" + (int) (Math.random() * 1000);
    }

    public void closeScanner() {
        scanner.close();
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
    }
}
