package com.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		
		super(String.format("Not found with %s =%s", message));
	}
}
