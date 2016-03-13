package com.candylife.util;

import com.candylife.enums.Type;

public class Parser {

	public static double parsePrice(String price) throws NumberFormatException {
		double result = Double.parseDouble(price);
		return result;
	}

	public static boolean parseAvailable(String available) {
		return available != null;
	}

	public static Type parseType(String parameter) {
		return Type.valueOf(parameter.toUpperCase());
	}
}
