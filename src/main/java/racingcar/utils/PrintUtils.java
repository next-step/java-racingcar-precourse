package racingcar.utils;

public class PrintUtils {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static void print(final String message) {
        System.out.print(message);
    }

    public static void println(final String message) {
        System.out.println(message);
    }

    public static void error(final String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
