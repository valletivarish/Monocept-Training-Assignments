package com.monocept.solution.test;

import com.monocept.solution.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();
        User user = new User(userName, userID);
        UserRegistration userRegister = new UserRegistration();
        userRegister.registerUser(user);
        while (true) {
            System.out.print("\nEnter book title (or type 0 to finish adding books): ");
            String bookTitle = scanner.nextLine();
            if (bookTitle.equals("0")) {
                break;
            }
            System.out.print("Enter author name: ");
            String authorName = scanner.nextLine();
            Book book = new Book(bookTitle, authorName);
            books.add(book);
            System.out.println("Book added to catalog");
        }
        System.out.println("\nCataloged Books:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
        }
        BorrowingStrategy borrowingStrategy = new BookBorrowingService();
        ReturningStrategy returningStrategy = new BookReturningService();
        UserBookInteraction userBookInteraction = new UserBookInteraction(borrowingStrategy, returningStrategy);
        while (true) {
            System.out.print("\nChoose a book to interact with (enter book number, or 0 to finish): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            Book selectedBook = books.get(choice - 1);
            interactWithBook(selectedBook, user, userBookInteraction, scanner);
        }
    }
    private static void interactWithBook(Book book, User user, UserBookInteraction userBookInteraction, Scanner scanner) {
        System.out.println("Selected book: " + book.getTitle() + " by " + book.getAuthor());
        System.out.println("\nChoose an action:");
        System.out.println("1. Borrow this book");
        System.out.println("2. Return this book");
        int actionChoice = scanner.nextInt();
        switch (actionChoice) {
            case 1:
                userBookInteraction.borrowBook(book, user);
                break;
            case 2:
                userBookInteraction.returnBook(book, user);
        }
    }
}
