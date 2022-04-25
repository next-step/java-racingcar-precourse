package racingcar.utils;

public final class StringUtils {

    private static final String CREATION_ERROR_MESSAGE = "[ERROR] Utility class";

    private StringUtils() {
        throw new IllegalStateException(CREATION_ERROR_MESSAGE);
    }

    public static String repeatString(String text, int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            sb.append(text);
        }
        return sb.toString();
    }

}
