package racinggame.utils;

public final class StringUtils {
	private StringUtils() {
	}

	public static boolean isBlank(String value) {
		return value == null || value.length() == 0;
	}
}
