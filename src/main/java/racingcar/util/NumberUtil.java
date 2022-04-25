package racingcar.util;

import java.util.regex.Pattern;

public class NumberUtil {
    private static final Pattern NUMBERS_PATTERN = Pattern.compile("\\d+?");

    public static boolean isNumber(String text) {
        if (text == null)
            return false;
        return NUMBERS_PATTERN.matcher(text).matches();
    }
}
