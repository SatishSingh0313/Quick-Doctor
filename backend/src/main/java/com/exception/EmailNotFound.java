package com.exception;

public class EmailNotFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailNotFound() {
		super("Email Not Found");
	}
}