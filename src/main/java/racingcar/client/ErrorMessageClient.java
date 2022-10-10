package racingcar.client;

public class ErrorMessageClient {
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private ErrorMessageClient() {
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }
}
