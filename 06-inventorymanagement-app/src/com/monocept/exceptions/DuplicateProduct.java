package com.monocept.exceptions;

public class DuplicateProduct extends RuntimeException{
	@Override
	public String getMessage() {
		return "Duplicate product";
	}
}
