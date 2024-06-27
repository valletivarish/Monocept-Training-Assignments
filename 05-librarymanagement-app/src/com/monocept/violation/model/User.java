package com.monocept.violation.model;

public class User {
	Book book;
	private String name;
	private String userID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public User(String name, String userID) {
		super();
		this.name = name;
		this.userID = userID;
		registerUser();
	}
	public User() {
		super();
	}
	public void registerUser() {
		System.out.println("User registered with the name "+this.name);
	}
	public void borrowBook(Book book, User user) {
		book.borrowBook(user);
	}
}
