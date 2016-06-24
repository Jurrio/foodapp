package com.candylife.exception;

import com.candylife.constants.ExceptionMessage;

public class PasswordsNotEqualException extends Exception {

	public PasswordsNotEqualException() {
		super();
	}

	@Override
	public String getMessage() {
		return ExceptionMessage.PASSWORDS_DO_NOT_MATCH;
	}
	
	

}
