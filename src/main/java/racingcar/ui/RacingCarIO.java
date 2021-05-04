package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;
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

    public static void printExecuteResult(String raceRecords) {
        printlnMessage(EXECUTE_RESULT.getMessage());
        printlnMessage(raceRecords);
    }

    public static void printWinners(List<Car> winner) {
        String winnerNames = toNames(winner);
        printlnMessage(winnerNames + WINNER_SUFFIX.getMessage());
    }

    private static String toNames(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        int size = winner.size();
        for (int i = 0; i < size; i++) {
            sb.append(winner.get(i).getCarName());
            sb.append(separator(size, i));
        }
        return sb.toString();
    }

    private static String separator(int size, int idx) {
        if (size - 1 > idx) {
            return ", ";
        }
        return "";
    }

    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

}
