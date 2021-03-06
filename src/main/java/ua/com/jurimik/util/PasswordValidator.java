package ua.com.jurimik.util;

import ua.com.jurimik.constant.ExceptionMessage;
import ua.com.jurimik.exception.PasswordLengthException;
import ua.com.jurimik.exception.PasswordsNotEqualException;

public class PasswordValidator {
	private static int minLen = 5;
	private static int maxLen = 25;

	public static boolean validate(String passwd, String repeat)
			throws PasswordsNotEqualException, PasswordLengthException {
		boolean result = (theSamePasswds(passwd, repeat) && lengthPasswd(passwd, minLen, maxLen));
		return result;
	}

	private static boolean theSamePasswds(String passwd1, String passwd2) throws PasswordsNotEqualException {
		if (!passwd1.equals(passwd2)) {
			throw new PasswordsNotEqualException(ExceptionMessage.PASSWORDS_DO_NOT_MATCH);
		}
		return passwd1.equals(passwd2);
	}

	private static boolean lengthPasswd(String passwd, int minLen, int maxLen) throws PasswordLengthException {
		int passwdLen = passwd.length();
		if (passwdLen < minLen || passwdLen > maxLen) {
			throw new PasswordLengthException("Length of password '" + passwd.length() + "'. "
					+ "Length should be from " + minLen + " to " + maxLen);
		}
		return true;
	}

}
