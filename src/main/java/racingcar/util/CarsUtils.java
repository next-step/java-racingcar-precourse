package racingcar.util;

import static org.junit.platform.commons.util.StringUtils.isBlank;

public class CarsUtils {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	public static boolean validateCarNames(String names) {
		if (isBlank(names) || names.split(",").length == 0) {
			return false;
		}
		int invalidNameCount = 0;
		for (String name : names.split(",")) {
			invalidNameCount += !validateCarName(name) ? 1 : 0;
		}
		return invalidNameCount == 0;
	}

	public static boolean validateCarName(String name) {
		return !isBlank(name) && name.length() <= CAR_NAME_MAX_LENGTH;
	}

	public static boolean validateTryNo(String tryNo) {
		int num;
		try {
			num = Integer.parseInt(tryNo);
		} catch (NumberFormatException e) {
			return false;
		}
		return num > 0;
	}
}
