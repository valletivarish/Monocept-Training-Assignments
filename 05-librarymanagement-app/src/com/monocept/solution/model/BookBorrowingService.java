package com.monocept.solution.model;

public class BookBorrowingService implements BorrowingStrategy {
    @Override
    public void borrowBook(Book book, User user) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println(user.getName() + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
}
