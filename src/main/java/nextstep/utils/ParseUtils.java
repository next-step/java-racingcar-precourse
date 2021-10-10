package nextstep.utils;

import nextstep.constants.CommonConstants;

public class ParseUtils {

	private ParseUtils() {
	}

	public static String[] parseByComma(String input) {
		return input.split(CommonConstants.COMMA);
	}
}
