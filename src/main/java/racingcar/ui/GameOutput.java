package racingcar.ui;

public class GameOutput {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + " " + message);
    }
}
