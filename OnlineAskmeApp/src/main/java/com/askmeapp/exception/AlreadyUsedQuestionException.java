package com.askmeapp.exception;

public class AlreadyUsedQuestionException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "You can already view this Question";
	} 

}
