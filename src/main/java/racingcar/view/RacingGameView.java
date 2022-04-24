package racingcar.view;

import racingcar.constant.Hint;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameView {

    public static void getReqCarNameMessage() {
        System.out.println(Hint.HINT_ASK_CAR_NAME.getMessage());
    }

    public static void getReqRaceNumberMessage() {
        System.out.println(Hint.HINT_ASK_RACE_NUMBER.getMessage());
    }

    public static void printResultMessage() {
        printLineBreak();
        System.out.println(Hint.HINT_RESULT.getMessage());
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static String getUserInput() {
        return readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printWinner() {
        System.out.print(Hint.HINT_WINNER.getMessage());
    }

}
