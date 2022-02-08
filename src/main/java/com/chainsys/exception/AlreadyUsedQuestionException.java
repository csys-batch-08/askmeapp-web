package com.chainsys.exception;

public class AlreadyUsedQuestionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "You can already view this Question";
	}

}
