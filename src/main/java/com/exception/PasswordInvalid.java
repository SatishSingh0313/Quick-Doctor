package com.exception;

public class PasswordInvalid extends RuntimeException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordInvalid()
	{
		super("Password invalid");
	}

}