package com.monocept.violation.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<User> users = new ArrayList<>();
    private String name;
    private String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
		super();
	}

	public void borrowBook(Book book, User user) {
        book.borrowBook(user, book);
    }

    public void registerUser(User user) {
        System.out.println("\nUser successfully registered with username " + user.name);
        System.out.println("ID: " + user.userId + "\n");
        users.add(user);
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", userId=" + userId + "]";
    }
}
