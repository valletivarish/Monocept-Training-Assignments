package com.monocept.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.monocept.exceptions.DuplicateProduct;
import com.monocept.exceptions.DuplicateSuppliers;

public class Inventory {
    private List<Product> products = new ArrayList<>();
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addProduct(Product product) {
        boolean found = false;
        for (Product prod : products) {
            if (prod.getProductID().equals(product.getProductID())) {
                found = true;
                break;
            }
        }
        if (found) {
            throw new DuplicateProduct();
        }
        products.add(product);
        System.out.println(product);
    }

    public boolean deleteProduct(String productId) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getProductID().equals(productId)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            return true;
        }
        return false;
    }

    public Product findProductById(String productId) {
        for (Product product : products) {
            if (product.getProductID().equals(productId)) {
                return product;
            }
        }
        return null;
    }

//    public Product findProductByName(String productName) {
//        for (Product product : products) {
//            if (product.getProductName().equals(productName)) {
//                return product;
//            }
//        }
//        return null;
//    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addSupplier(Supplier supplier) {
        boolean found = false;
        for (Supplier supp : suppliers) {
            found = true;
        }
        if (found) {
            throw new DuplicateSuppliers();
        }
        suppliers.add(supplier);
        System.out.println(supplier);
    }

    public boolean updateSupplier(String supplierId, String updatedName, long updatedContactInfo) {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierID().equals(supplierId)) {
                supplier.setName(updatedName);
                supplier.setContactInformation(updatedContactInfo);
                return true;
            }
        }
        return false;
    }

    public boolean deleteSupplier(String supplierId) {
        Supplier supplierToRemove = null;
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierID().equals(supplierId)) {
                supplierToRemove = supplier;
                break;
            }
        }
        if (supplierToRemove != null) {
            suppliers.remove(supplierToRemove);
            return true;
        }
        return false;
    }

    public Supplier findSupplierById(String supplierId) {
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplierID().equals(supplierId)) {
                return supplier;
            }
        }
        return null;
    }

    public List<Supplier> getAllSuppliers() {
        return suppliers;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void loadData() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\Monocept-Training-Assignments\\06-inventorymanagement-app\\src\\com\\monocept\\model\\ProductFile.txt");
            ObjectInputStream object = new ObjectInputStream(fileInputStream);
            while (true) {
                try {
                    Product product = (Product) object.readObject();
                    if (product == null) {
                        break;
                    }
                    System.out.println(product);
                    boolean found = false;
                    for (Product prod : products) {
                        if (prod.getProductID().equals(product.getProductID())) {
                            found = true;
                            prod.setQuantity(product.getQuantity());
                            break;
                        }
                    }
                    if (!found) {
                        products.add(product);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            object.close();

            fileInputStream = new FileInputStream("D:\\Monocept-Training-Assignments\\06-inventorymanagement-app\\src\\com\\monocept\\model\\SupplierFile.txt");
            object = new ObjectInputStream(fileInputStream);
            while (true) {
                try {
                    Supplier supplier = (Supplier) object.readObject();
                    if (supplier == null) {
                        break;
                    }
                    System.out.println(supplier);
                    boolean found = false;
                    for (Supplier supp : suppliers) {
                        if (supp.getSupplierID().equals(supplier.getSupplierID())) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        suppliers.add(supplier);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            object.close();


            fileInputStream = new FileInputStream("D:\\Monocept-Training-Assignments\\06-inventorymanagement-app\\src\\com\\monocept\\model\\TransactionFile.txt");
            object = new ObjectInputStream(fileInputStream);
            while (true) {
                try {
                    Transaction transaction = (Transaction) object.readObject();
                    if (transaction == null) {
                        break;
                    }
                    System.out.println(transaction);
                    boolean found = false;
                    for (Transaction transact : transactions) {
                        if (transact.getTransactionID().equals(transaction.getTransactionID())) {
                            found = true;
                            transact.setQuantity(transaction.getQuantity());
                            break;
                        }
                    }
                    if (!found) {
                        transactions.add(transaction);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Loaded the data from file successfully");
            object.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveData() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Monocept-Training-Assignments\\06-inventorymanagement-app\\src\\com\\monocept\\model\\ProductFile.txt");
        ObjectOutputStream file = new ObjectOutputStream(fileOutputStream);
        for (Product product : products) {
            file.writeObject(product);
        }
        fileOutputStream = new FileOutputStream("D:\\Monocept-Training-Assignments\\06-inventorymanagement-app\\src\\com\\monocept\\model\\SupplierFile.txt");
        file = new ObjectOutputStream(fileOutputStream);
        for (Supplier supplier : suppliers) {
            file.writeObject(supplier);
        }
        fileOutputStream = new FileOutputStream("D:\\Monocept-Training-Assignments\\06-inventorymanagement-app\\src\\com\\monocept\\model\\TransactionFile.txt");
        file = new ObjectOutputStream(fileOutputStream);
        for (Transaction transaction : transactions) {
            file.writeObject(transaction);
        }
        System.out.println("Saved the data in file successfully");
    }

    public void generateReports() {
        System.out.println("Total Products : " + products.size());
        double totalValue = 0;
        for (Product product : products) {
            totalValue = product.getQuantity() * product.getPrice();
            String formattedNumber = String.format("%.0f", totalValue);
            System.out.println("Product " + product.getProductName() + " its value is " + formattedNumber);

        }
    }
}
