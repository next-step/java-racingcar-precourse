package racingcar.io;

import static racingcar.constants.Message.ERROR_MESSAGE_PATTERN;

public class Output {

    private Output() {

    }

    public static void print(final Object message) {
        System.out.print(message);
    }

    public static void println(final Object message) {
        System.out.println(message);
    }

    public static void error(final Object message) {
        System.out.println(String.format(ERROR_MESSAGE_PATTERN, message));
    }

    public static void line() {
        System.out.println();
    }
}
