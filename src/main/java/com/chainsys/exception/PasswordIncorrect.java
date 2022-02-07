package com.chainsys.exception;

public class PasswordIncorrect extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {

		return "Password Incorrect";
	} 

}
