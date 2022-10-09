package racingcar.view;

import racingcar.constant.GameEnvironment;
import racingcar.constant.GameMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Names;

public class OutputConsole {

    public static void printErrorView(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printRaceResult(Cars cars) {
        printResultTitle();
        printEachRaceResult(cars);
    }

    private static void printResultTitle() {
        System.out.println(GameMessage.RACE_RESULT_OUTPUT);
    }

    private static void printEachRaceResult(Cars cars) {
        for (Car car : cars.getValue()) {
            String carName = car.getName();
            String bar = bar(car.getPosition().getValue());

            System.out.println(String.format(GameMessage.EACH_RESULT_OUTPUT, carName, bar));
        }
        System.out.println();
    }

    private static String bar(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static void printWinner(Names winners) {
        printWinnerPrefix();
        printEachWinner(winners);
    }

    private static void printWinnerPrefix() {
        System.out.print(GameMessage.RACE_WINNER_OUTPUT);
    }

    private static void printEachWinner(Names winners) {
        StringBuilder builder = new StringBuilder();
        int numberOfWinner = winners.size();

        for (int i = 0; i < numberOfWinner; i++) {
            builder.append(winners.get(i).getValue());
            if (i < numberOfWinner - 1) {
                builder.append(String.format("%s%s", GameEnvironment.CAR_NAME_DELIMITER, " "));
            }
        }

        System.out.println(builder);
    }
}
