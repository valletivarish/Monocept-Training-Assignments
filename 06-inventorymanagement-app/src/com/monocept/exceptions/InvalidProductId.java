package com.monocept.exceptions;

public class InvalidProductId extends RuntimeException{
	@Override
	public String getMessage()
	{
		return "Ivalid Product id";
		
	}
}
