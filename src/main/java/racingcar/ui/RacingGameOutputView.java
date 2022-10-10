package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.RacingGameResult;
import racingcar.exception.RacinggameException;

public class RacingGameOutputView {

    private static final String EMPTY_LINE = "\n";
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String COLON = " : ";
    private static final String DASH = "-";

    public static void printEmptyLine() {
        System.out.print(EMPTY_LINE);
    }

    public static void printExecuteResult() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void printRoundResult(Car car) {
        System.out.print(car.getName() + COLON + printDash(car.getPosition()));
    }

    private static String printDash(int position) {
        StringBuilder dashes = new StringBuilder();

        for (int i = 0; i < position; i++) {
            dashes.append(DASH);
        }

        return dashes.toString();
    }

    public static void printWinner(RacingGameResult racingGameResult) {
        System.out.println(racingGameResult.getGameResult());
    }

    public static void error(RacinggameException racinggameException) {
        System.out.println(racinggameException.getMessage());
    }
}
