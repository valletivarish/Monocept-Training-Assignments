package com.monocept.solution.model;

public class BookReturningService implements ReturningStrategy {
    @Override
    public void returnBook(Book book, User user) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println(user.getName() + " has returned the book: " + book.getTitle());
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}
