package main.java.exception;

public class EmailFormatException extends Exception {

	private static final long serialVersionUID = 4945770897892369121L;
	
	public EmailFormatException(String email) {
		super("Wrong format of email: " + email);
	}	

}
