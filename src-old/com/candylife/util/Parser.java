package com.candylife.util;

import org.apache.log4j.Logger;

public class Parser {

	public static Logger LOG = Logger.getLogger(Parser.class.getName());
	
	public static double parsePrice(String price) throws NumberFormatException {
		LOG.debug("price: " + price);
		return Double.parseDouble(price);
	}

	public static boolean parseAvailable(String available) {
		LOG.debug("available: " + available);
		return available != null;
	}

	public static int parseId(String parameter) throws NumberFormatException {
		LOG.debug("id: " + parameter);
		return Integer.parseInt(parameter);
	}
}
