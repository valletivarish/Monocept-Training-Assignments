package com.monocept.exceptions;

public class InsufficientStock extends RuntimeException{
	@Override
	public String getMessage()
	{
		return "Insufficent products";
		
	}
}
