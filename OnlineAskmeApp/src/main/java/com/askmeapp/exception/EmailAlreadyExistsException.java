package com.askmeapp.exception;


public class EmailAlreadyExistsException extends Exception{
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Email already exist";
	} 
}
