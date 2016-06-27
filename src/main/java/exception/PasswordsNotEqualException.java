package main.java.exception;

public class PasswordsNotEqualException extends Exception {

	private static final long serialVersionUID = -4859304523650555818L;

	public PasswordsNotEqualException() {
		super();
	}

	public PasswordsNotEqualException(String message) {
		super(message);
	}
}
