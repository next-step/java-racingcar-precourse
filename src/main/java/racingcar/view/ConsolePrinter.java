package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ConsolePrinter {
    private static final String GAME_RESULT_PRINT_FORMAT = "%s : %s";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printConsoleMsg(Messages msg) {
        System.out.println(msg.getMsg());
    }

    public static void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(GAME_RESULT_PRINT_FORMAT, car.getName(), car.getCarPositionByStr()));
        }
        System.out.println();
    }

    public static void printWinnerNames(List<String> winnerNames) {
        String result = new String();
        result = result.concat(Messages.GAME_WINNER.getMsg());
        for (String name : winnerNames) {
            result = result.concat(name).concat(WINNER_NAME_DELIMITER);
        }

        System.out.println(result.substring(0, result.length() - 2));
    }
}
