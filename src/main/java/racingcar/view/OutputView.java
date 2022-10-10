package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;
import racingcar.domain.Winner;
import racingcar.message.ErrorMessage;
import racingcar.message.OutputMessage;

public class OutputView {
    public static final String DELIMITER = ", ";
    public static final String NAME_RESULT_JOIN_STRING = " : ";
    public static final String RESULT_POSITION_OUTPUT = "-";

    public static void printResult() {
        System.out.println(OutputMessage.OUTPUT_GAME_RESULT);
    }

    public static void printWinners(Winner winner) {
        System.out.print(OutputMessage.OUTPUT_WINNERS);
        System.out.println(String.join(DELIMITER, winner.getWinners()));
    }

    public static void printCurrentRoundResult(Cars cars) {
        for (Car car : cars.cars()) {
            printCurrentResultAboutCar(car);
        }
        printBlankLine();
    }

    private static void printCurrentResultAboutCar(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.name());
        builder.append(NAME_RESULT_JOIN_STRING);
        Position currentIndex = new Position(0);
        while (car.position().isBiggerPosition(currentIndex)) {
            builder.append(RESULT_POSITION_OUTPUT);
            currentIndex.plus(1);
        }
        System.out.println(builder);
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(ErrorMessage.ERROR_PREFIX + e.getMessage());
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
