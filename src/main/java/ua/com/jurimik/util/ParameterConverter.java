package ua.com.jurimik.util;

import org.apache.log4j.Logger;

public class ParameterConverter {

	public static Logger LOG = Logger.getLogger(ParameterConverter.class);

	public static double convertDouble(String price) throws NumberFormatException {
		LOG.debug("convert double: " + price);
		return Double.parseDouble(price);
	}

	public static boolean convertBoolean(String available) {
		LOG.debug("convert boolean: " + available);
		return available != null;
	}

	public static int convertInteger(String parameter) throws NumberFormatException {
		LOG.debug("convert integer: " + parameter);
		return Integer.parseInt(parameter);
	}
}
