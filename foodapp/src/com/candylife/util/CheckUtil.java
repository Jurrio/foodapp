package com.candylife.util;

public class CheckUtil {

	public static double parsePrice(String price) {
		double result;
		try {
			result = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			result = 0.0;
		}
		return result;
	}

	public static boolean parseAvailable(String available) {
		return available != null;
	}

}
