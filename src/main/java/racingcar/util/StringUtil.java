package racingcar.util;

public final class StringUtil {
    private final static String COMMA = ",";

    private StringUtil() {
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA);
    }
}
