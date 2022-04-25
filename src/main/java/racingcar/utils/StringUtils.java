package racingcar.utils;

public class StringUtils {
    public static boolean hasText(final String text) {
        return text != null && text.length() > 0;
    }

    public static boolean hasNotText(final String text) {
        return !hasText(text);
    }
}
