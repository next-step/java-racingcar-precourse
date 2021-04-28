package util;

public class StringUtil {
	public static String[] splitNameByComma(String name) {
		return name.split(",");
	}

	public static String cutFiveLength(String s) {
		return s == null ? null : s.substring(0, 5);
	}
}
