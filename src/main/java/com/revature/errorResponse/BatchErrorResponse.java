package com.revature.errorResponse;

/**
 * This is a class that represents a Java Object for an error 
 * response.  It provides getters and setters for all properties.
 */
public class BatchErrorResponse {
	
	private int status;
	private String message;
	private long timestamp;
	
	public BatchErrorResponse() { }

	public BatchErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
