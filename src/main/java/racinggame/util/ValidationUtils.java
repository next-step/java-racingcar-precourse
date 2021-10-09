package racinggame.util;

public class ValidationUtils {

	public static boolean validCarName(String string) {
		return string != null && !"".equals(string) && string.length() <= 5;
	}

}
