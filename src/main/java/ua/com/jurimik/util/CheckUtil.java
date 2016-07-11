package ua.com.jurimik.util;

import ua.com.jurimik.constant.Messages;
import ua.com.jurimik.exception.SearchEmptyException;
import ua.com.jurimik.exception.SearchManyParamException;

public class CheckUtil {
	public static String checkSearchvalue(String searchValue) throws SearchManyParamException, SearchEmptyException {
		if (searchValue.split(" ").length > 1)
			throw new SearchManyParamException(Messages.SEARCH_TOO_MANY_WORD);
		if (searchValue.trim().isEmpty())
			throw new SearchEmptyException(Messages.SEARCH_EMPTY_QUERY);
		return searchValue;
	}
}
