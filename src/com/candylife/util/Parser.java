package com.candylife.util;

import com.candylife.enums.Type;

public class Parser {

	public static double parsePrice(String price) throws NumberFormatException {
		return Double.parseDouble(price);
	}

	public static boolean parseAvailable(String available) {
		return available != null;
	}

	public static Type parseType(String parameter) throws IllegalArgumentException {
		return Type.valueOf(parameter.toUpperCase());
	}

	public static int parseId(String parameter) throws NumberFormatException {
		return Integer.parseInt(parameter);
	}
}
