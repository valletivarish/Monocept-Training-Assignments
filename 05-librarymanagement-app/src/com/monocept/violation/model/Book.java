package com.monocept.violation.model;

public class Book {
	private String title;
	 private String author;
	 private boolean isBorrowed;
	public Book(String title, String author) {
		super();
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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public void borrowBook(User user) {
		System.out.println(user.getName() + " has borrowed the book");
	}
	public void returnBook(User user) {
		System.out.println(user.getName()+" has return the book");
	}
	public void catalogBook(Book book) {
		System.out.println("Book title: " + book.getTitle() + ", Author: " + book.getAuthor());
	}
}
