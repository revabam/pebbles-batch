package com.revature.exceptions;

public class BatchNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BatchNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BatchNotFoundException(String message) {
		super(message);
	}

	public BatchNotFoundException(Throwable cause) {
		super(cause);
	}

}
