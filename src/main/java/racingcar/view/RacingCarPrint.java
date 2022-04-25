package racingcar.view;

import racingcar.constant.Symbol;
import racingcar.message.Message;

public class RacingCarPrint {

    public static String inputRacingCarName() {
        println(Message.RACING_CAR_NAME_INPUT.getMessage());
        return RacingCarInput.inputUser();
    }

    public static String inputAttemptCount() {
        println(Message.ATTEMPTS_COUNT_INPUT.getMessage());
        return RacingCarInput.inputUser();
    }

    public static void printRaceResult(String result) {
        String resultPrint = new StringBuilder()
                        .append(Message.RACE_RESULT.getMessage())
                        .append(Symbol.LINE.getValue())
                        .append(result)
                        .toString();

        print(resultPrint);
    }

    public static void printFinalWinner(String winner) {
        print(String.format(Message.RACE_USER_RESULT.getMessage(), winner));
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

}
