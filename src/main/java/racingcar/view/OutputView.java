package racingcar.view;

import racingcar.util.Message;

public class OutputView {
    private OutputView() {}

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        System.out.println(Message.ERROR_PREFIX.getMessage() + message);
    }
}
