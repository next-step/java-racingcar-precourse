package racinggame.util;

public class ValidationUtils {

	public static final int MAX_CAR_NAME = 5;

	public static boolean validCarName(String string) {
		return string != null && !"".equals(string) && string.length() <= MAX_CAR_NAME;
	}

}
