package utils;

public class ValidationUtils {
	public static boolean vaildString(String str) {
		return str.length() <= 5;
	}

	public static boolean vaildNumber(String no) {
		if (isPresentString(no)) {
			return false;
		}
		String regex = "[0-9]+";
		return no.matches(regex);
	}

	private static boolean isPresentString(String str) {
		return str.trim().length() == 0 || str == null;
	}
}
