package ua.com.jurimik.exception;

public class PasswordLengthException extends Exception {

	private static final long serialVersionUID = -2371134404468862988L;

	public PasswordLengthException(String message) {
		super(message);
	}

}
