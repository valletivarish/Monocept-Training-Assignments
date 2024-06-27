package com.monocept.solution.model;

public class BookCatalog {
    public void catalogBook(Book book) {
        System.out.println("Book title: " + book.getTitle() + ", Author: " + book.getAuthor());
    }
}
