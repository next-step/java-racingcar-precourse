package racingcar.ui;

import java.util.Scanner;

import static racingcar.ui.message.IOMessage.REQUEST_CAR_NAMES;

public class RacingcarIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestCarNames() {
        printlnMessage(REQUEST_CAR_NAMES.getMessage());
        return scanner.nextLine();
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }
}
