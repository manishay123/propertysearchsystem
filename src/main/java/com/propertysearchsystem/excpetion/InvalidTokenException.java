package com.propertysearchsystem.excpetion;

public class InvalidTokenException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public InvalidTokenException(String message) {
		super(message);
	}

}
