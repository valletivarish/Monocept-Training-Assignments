package com.monocept.solution.model;

public class UserBookInteraction {
    private BorrowingStrategy borrowingStrategy;
    private ReturningStrategy returningStrategy;

    public UserBookInteraction(BorrowingStrategy borrowingStrategy, ReturningStrategy returningStrategy) {
        this.borrowingStrategy = borrowingStrategy;
        this.returningStrategy = returningStrategy;
    }

    public void borrowBook(Book book, User user) {
        borrowingStrategy.borrowBook(book, user);
    }

    public void returnBook(Book book, User user) {
        returningStrategy.returnBook(book, user);
    }
}
