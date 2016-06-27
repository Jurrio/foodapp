package com.candylife.exception;

import com.candylife.constants.ExceptionMessage;

public class SearchEmptyException extends Exception {

	private static final long serialVersionUID = 3971641390821243837L;

	public SearchEmptyException() {
		super();
	}

	@Override
	public String getMessage() {
		return ExceptionMessage.SEARCH_EMPTY_MESSAGE;
	}
	
	
}
