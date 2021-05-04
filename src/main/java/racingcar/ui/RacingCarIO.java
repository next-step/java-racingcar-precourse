package racingcar.ui;

import java.util.Scanner;

import static racingcar.ui.message.IOMessage.*;

public class RacingCarIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestCarNames() {
        printlnMessage(REQUEST_CAR_NAMES.getMessage());
        return scanner.nextLine();
    }

    public static String requestRound() {
        printlnMessage(REQUEST_ROUND.getMessage());
        return scanner.nextLine();
    }

    public static void printRaceResult(String raceRecords) {
        printlnMessage(RACE_RESULT.getMessage());
        printlnMessage(raceRecords);
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

}
