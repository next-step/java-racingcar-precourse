package racinggame;

public class ValidationUtils {

	public static boolean validCarNameLength(String carName) {
		return carName.length() <= 5;
	}

	public static boolean validCarNameContainsRest(String carName) {
		boolean result = false;
		for (int i = 0; i < carName.length() && !result; i++) {
			result = isCarNameContainsRest(carName.split("")[i]);
		}

		return result;
	}

	private static boolean isCarNameContainsRest(String carName) {
		return ",".equals(carName);
	}
}
