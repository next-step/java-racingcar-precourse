package racinggame.utils;

import java.util.List;

public class ValidationUtil {
	private ValidationUtil() {
	}

	public static boolean validCarNameLength(List<String> carsName) {
		for (String carName : carsName) {
			int carNameLength = carName.length();
			if (carNameLength < 1 || carNameLength >= 6) {
				return false;
			}
		}
		return true;
	}
}
