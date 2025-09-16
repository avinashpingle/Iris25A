package com.skillio.exceptions;

public class InvalidLocatorException extends RuntimeException{

	public InvalidLocatorException(String locatorType) {
		super("Locator "+locatorType+" is not supported");
	}
	
}
