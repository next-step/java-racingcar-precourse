package racinggame.utils;

public class ValidationUtil {
	private ValidationUtil() {
	}

	public static boolean validCarNameLength(String[] carsName) {
		for (String carName : carsName) {
			int carNameLength = carName.length();
			if (carName.isEmpty() || isNameLength5More(carNameLength)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isNameLength5More(int carNameLength) {
		return carNameLength >= 6;
	}

	public static boolean validOnlyNumber(String s) {
		return s.matches("\\d+");
	}
}
