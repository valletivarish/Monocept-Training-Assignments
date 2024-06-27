package com.monocept.violation.test;

import com.monocept.violation.model.Book;
import com.monocept.violation.model.User;

public class LibraryManagementTest {

	public static void main(String[] args) {
		User user=new User("Varish","20eg");
		Book book=new Book("1984","John");
		book.catalogBook(book);
		user.borrowBook(book,user);
		book.returnBook(user);
	}
}
