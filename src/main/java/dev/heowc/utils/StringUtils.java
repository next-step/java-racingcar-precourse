package dev.heowc.utils;

public abstract class StringUtils {

    public static boolean hasText(String value) {
        return value != null && value.length() > 0;
    }

    public static String repeat(char ch, int count) {
        final StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            buffer.append(ch);
        }
        return buffer.toString();
    }

    private StringUtils() {}
}
