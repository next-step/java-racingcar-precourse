package racingcar.util;

public class ErrorMessageUtil {
    private static final String MESSAGE_ERROR_PREFIX = "[ERROR]";

    private ErrorMessageUtil() {
    }

    public static String getMessage(String message) {
        return String.format("%s %s", MESSAGE_ERROR_PREFIX, message);
    }
}
