package com.candylife.exception;

import com.candylife.constants.ExceptionMessage;

public class SearchManyParamException extends Exception {
	public SearchManyParamException() {
		super();
	}

	@Override
	public String getMessage() {
		return ExceptionMessage.SEARCH_MANY_PARAM_MESSAGE;
	}
}
