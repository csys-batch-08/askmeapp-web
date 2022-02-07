package com.chainsys.exception;


public class EmailAlreadyExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {

		return "Email already exist";
	} 
}
