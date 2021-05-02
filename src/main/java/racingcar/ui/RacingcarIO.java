package racingcar.ui;

import java.util.Scanner;

import static racingcar.ui.message.IOMessage.REQUEST_CAR_NAMES;
import static racingcar.ui.message.IOMessage.REQUEST_ROUND;

public class RacingcarIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestCarNames() {
        printlnMessage(REQUEST_CAR_NAMES.getMessage());
        return scanner.nextLine();
    }

    public static String requestRound() {
        printlnMessage(REQUEST_ROUND.getMessage());
        return scanner.nextLine();
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

}
