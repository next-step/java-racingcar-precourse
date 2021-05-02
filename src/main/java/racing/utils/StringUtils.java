package racing.utils;

import java.util.Collections;

public class StringUtils {
	public static final String NEW_LINE = "\n";

	private StringUtils() {
		// do nothing
	}

	public static String repeat(String str, int times) {
		return String.join("", Collections.nCopies(times, str));
	}
}
