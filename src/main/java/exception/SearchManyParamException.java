package main.java.exception;

import main.java.constant.ExceptionMessage;

public class SearchManyParamException extends Exception {
	
	private static final long serialVersionUID = 8227890952823692877L;

	public SearchManyParamException() {
		super();
	}

	@Override
	public String getMessage() {
		return ExceptionMessage.SEARCH_MANY_PARAM_MESSAGE;
	}
}
