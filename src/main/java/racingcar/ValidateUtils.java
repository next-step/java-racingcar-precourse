package racingcar;

public class ValidateUtils {

	public static boolean isNotNumber(String numberText) {
		try {
			Integer.parseInt(numberText);
			return false;
		} catch (NumberFormatException exception) {
			return true;
		}
	}

	public static boolean isLessThan6Char(String name) {
		return name.length() > 0 && name.length() < 6;
	}
}