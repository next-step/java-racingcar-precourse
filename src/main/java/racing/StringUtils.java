package racing;

import java.util.Collections;

public class StringUtils {
	static final String NEW_LINE = "\n";

	private StringUtils() {
		// do nothing
	}

	public static String repeat(String s, int n) {
		return String.join("", Collections.nCopies(n, s));
	}
}
