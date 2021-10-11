package racinggame;

import java.util.Arrays;
import java.util.HashSet;

public class ValidationUtils {
	public static final int MIN_SIZE = 2;
	public static final int MAX_LENGTH = 5;
	public static final String NAME_DELIMITER = ",";
	public static final int zero = 0;

	public static boolean validName(String inputCarName) {
		if (getStringArr(inputCarName).length == getStringHashSet(getStringArr(inputCarName)).size()) {
			return true;
		}
		return false;
	}

	public static boolean validNameLength(String name) {
		if (name.length() > MAX_LENGTH) {
			return false;
		}
		return true;
	}

	public static boolean validTwoMore(String inputCarName) {
		if (getStringHashSet(getStringArr(inputCarName)).size() >= MIN_SIZE) {
			return true;
		}
		return false;
	}

	private static String[] getStringArr(String name) {
		return name.split(NAME_DELIMITER);
	}

	private static HashSet<String> getStringHashSet(String[] strings) {
		return new HashSet<>(Arrays.asList(strings));

	}

	public static boolean validNumber(String number) {
		if (number.chars().allMatch(Character::isDigit)) {
			return true;
		}
		return false;
	}

	public static boolean validZeroMore(String number) {
		if (Integer.parseInt(number) > zero) {
			return true;
		}
		return  false;
	}
}

