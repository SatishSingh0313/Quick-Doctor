package com.exception;

public class PasswordInvalidException extends RuntimeException{
	
	String inavildPassword;

	public PasswordInvalidException(String inavildPassword) {
		super(inavildPassword);
		this.inavildPassword = inavildPassword;
	}
	

}
