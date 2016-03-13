package com.candylife.util;

import com.candylife.exception.SearchEmptyException;
import com.candylife.exception.SearchManyParamException;

public class CheckUtil {
	public static String checkSearchvalue(String searchValue) throws SearchManyParamException, SearchEmptyException{
		if (searchValue.split(" ").length > 1) throw new SearchManyParamException();
		if (searchValue.trim().equals("")) throw new SearchEmptyException();
		return searchValue;
	}
}
