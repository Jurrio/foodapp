package com.candylife.exception;

import com.candylife.constants.ExceptionMessage;

public class SearchEmptyException extends Exception {
	public SearchEmptyException() {
		super();
	}

	@Override
	public String getMessage() {
		return ExceptionMessage.SEARCH_EMPTY_MESSAGE;
	}
	
	
}
