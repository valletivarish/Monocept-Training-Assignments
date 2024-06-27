package com.monocept.violation.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<Book> books = new ArrayList<>();
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public Book() {
		super();
	}

	public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook(User user, Book book) {
        System.out.println(user.getName() + " has taken the " + book.getTitle());
        book.isBorrowed = true;
    }

    public void returnBook(Book book, User user) {
        System.out.println(user.getName() + " has returned the " + book.getTitle());
        book.isBorrowed = false;
    }

    public void catalogBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isBorrowed=" + isBorrowed + "]";
    }
}
