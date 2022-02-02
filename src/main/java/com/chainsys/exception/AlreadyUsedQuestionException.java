package com.chainsys.exception;

public class AlreadyUsedQuestionException extends Exception{
	@Override
	public String getMessage() {

		return "You can already view this Question";
	} 

}
