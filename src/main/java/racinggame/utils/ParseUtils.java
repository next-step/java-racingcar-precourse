package racinggame.utils;

import racinggame.constants.CommonConstants;
import racinggame.exception.InvalidTryCountInputException;

public class ParseUtils {

	private ParseUtils() {
	}

	public static String[] parseByComma(String input) {
		return input.split(CommonConstants.COMMA);
	}

	public static int parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new InvalidTryCountInputException();
		}
	}
}
