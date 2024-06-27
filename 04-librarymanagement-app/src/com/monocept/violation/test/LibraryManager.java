package com.monocept.violation.test;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.monocept.violation.model.Book;
import com.monocept.violation.model.User;

public class LibraryManager {

    public static void main(String[] args) {
        User user = new User();
        Book book = new Book();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        System.out.println("Welcome to the library");
        while (!isExit) {
            System.out.println("Choose option:\n1. Register a User\n2. Add a book\n3. Borrow a book\n4. Return a book\n5. Display the available books \n6. Exit");
            int selectedOption = scanner.nextInt();
            switch (selectedOption) {
                case 1:
                    System.out.println("You choose register a user");
                    registerUser(scanner, random, user);
                    break;
                case 2:
                    System.out.println("You choose add a book");
                    addBook(scanner, book);
                    break;
                case 3:
                    System.out.println("You choose Borrow a book");
                    borrowBook(book, user, scanner, user.getUsers(), book.getBooks());
                    break;
                case 4:
                    System.out.println("You choose Return a book");
                    returnBook(book, user, scanner, user.getUsers(), book.getBooks());
                    break;
                case 5:
                    System.out.println("You choose display books");
                    displayAvailableBooks(book.getBooks());
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    private static void displayAvailableBooks(List<Book> books) {
        boolean availableBooksExist = false;
        System.out.println("Available Books:");
        for (Book b : books) {
            if (!b.isBorrowed()) {
                System.out.println("Title: " + b.getTitle() + " | Author: " + b.getAuthor());
                availableBooksExist = true;
            }
        }
        if (!availableBooksExist) {
            System.out.println("Sorry, no books are available currently.");
        }
    }

    private static void returnBook(Book book, User user, Scanner scanner, List<User> users, List<Book> books) {
        User userFound = findUser(users, scanner);
        Book bookFound = findBook(books, scanner);

        if (userFound != null && bookFound != null) {
            book.returnBook(bookFound, userFound);
            System.out.print("Do you want to take another book : ");
            String userChoice = scanner.next();
            if (userChoice.equalsIgnoreCase("Yes")) {
                borrowBook(book, user, scanner, users, books);
            }
        }
    }

    private static void borrowBook(Book book, User user, Scanner scanner, List<User> users, List<Book> books) {
        User userFound = findUser(users, scanner);
        Book bookFound = findBook(books, scanner);

        if (userFound != null && bookFound != null) {
            user.borrowBook(bookFound, userFound);
        }
    }

    private static User findUser(List<User> users, Scanner scanner) {
        System.out.print("Enter User ID : ");
        String userID = scanner.next();
        for (User u : users) {
            if (u.getUserId().equals(userID)) {
                return u;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    private static Book findBook(List<Book> books, Scanner scanner) {
        System.out.print("Enter Book title : ");
        String bookTitle = scanner.next();
        for (Book b : books) {
            if (b.getTitle().equals(bookTitle)) {
                return b;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    private static void addBook(Scanner scanner, Book book) {
        System.out.print("Enter a title : ");
        String title = scanner.next();
        System.out.print("Enter an author : ");
        String author = scanner.next();
        book.catalogBook(new Book(title, author));
    }

    private static void registerUser(Scanner scanner, Random random, User user) {
        System.out.print("Enter a First Name : ");
        String firstName = scanner.next();
        System.out.print("Enter a Last Name : ");
        String lastName = scanner.next();
        String userID = generateUserId(random);
        user.registerUser(new User((firstName + " " + lastName), userID));
    }

    private static String generateUserId(Random random) {
        char randomChar = (char) (random.nextInt(26) + 'A');
        int randomNumber = random.nextInt(1000);
        return randomChar + "-" + String.format("%03d", randomNumber);
    }
}
