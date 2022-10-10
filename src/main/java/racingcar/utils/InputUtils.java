package racingcar.utils;

public class InputUtils {

	private static final String INVALID_NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해주세요.";

	private InputUtils() {
	}

	public static String inputString(String input) {
		return input;
	}

	public static int inputInt(String input) {
		return getInteger(input);
	}

	private static Integer getInteger(String input) {
		int integer;
		try {
			integer = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR_MESSAGE);
		}
		return integer;
	}
}
