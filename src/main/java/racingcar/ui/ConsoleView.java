package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    public static final String ERROR_PREFIX = "[ERROR]";

    public static String input(ConsoleMessage consoleMessage) {
        System.out.println(consoleMessage.getMessage());
        return Console.readLine();
    }

    public static void printMessage(String message, Object... args) {
        System.out.printf(message, args);
    }

    public static void printMessage(ConsoleMessage consoleMessage) {
        System.out.println(consoleMessage.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.printf("%s %s%n", ERROR_PREFIX, e.getMessage());
    }

    public static void newLine() {
        System.out.println();
    }
}
