package main.java.util;

import main.java.exception.SearchEmptyException;
import main.java.exception.SearchManyParamException;

public class CheckUtil {
	public static String checkSearchvalue(String searchValue) throws SearchManyParamException, SearchEmptyException{
		if (searchValue.split(" ").length > 1) throw new SearchManyParamException();
		if (searchValue.trim().isEmpty()) throw new SearchEmptyException();
		return searchValue;
	}
}
