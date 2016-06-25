package com.candylife.exception;

import com.candylife.constants.ExceptionMessage;

public class PasswordsNotEqualException extends Exception {

	private static final long serialVersionUID = -4859304523650555818L;

	public PasswordsNotEqualException() {
		super();
	}

	public PasswordsNotEqualException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return ExceptionMessage.PASSWORDS_DO_NOT_MATCH;
	}
	
	

}
