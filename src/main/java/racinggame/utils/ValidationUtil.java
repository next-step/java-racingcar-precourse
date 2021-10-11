package racinggame.utils;

public class ValidationUtil {
	private ValidationUtil() {
	}

	public static boolean validCarNameLength(String[] carsName) {
		boolean valid = true;
		for (String carName : carsName) {
			int carNameLength = carName.length();
			valid = setValid(valid, carName, carNameLength);
		}
		return valid;
	}

	private static boolean setValid(boolean valid, String carName, int carNameLength) {
		if (carName.isEmpty() || isNameLength5More(carNameLength)) {
			valid = false;
		}
		return valid;
	}

	private static boolean isNameLength5More(int carNameLength) {
		return carNameLength >= 6;
	}

	public static boolean validOnlyNumber(String s) {
		return s.matches("\\d+");
	}
}
