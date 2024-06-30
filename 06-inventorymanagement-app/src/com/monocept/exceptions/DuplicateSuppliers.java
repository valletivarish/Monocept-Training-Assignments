package com.monocept.exceptions;

public class DuplicateSuppliers extends RuntimeException{
	@Override
	public String getMessage() {
		return "Duplicate Supplier";
	}
}
