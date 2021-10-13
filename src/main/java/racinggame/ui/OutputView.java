package racinggame.ui;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void print(final String log) {
        System.out.println(log);
    }

    public static void printErrorMessage(final String log) {
        System.out.println(ERROR_PREFIX + log);
    }
}
