package com.propertysearchsystem.excpetion;

public class CustomMessageException extends Exception {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomMessageException(String exceptionMessage) {
	        super(exceptionMessage);
	    }
}
