package racingcar.view;

import racingcar.common.GameMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.WinnerCars;

public class OutputProvider {
    public static void printResultTitle() {
        System.out.printf(GameMessage.NEXT_LINE);
        System.out.println(GameMessage.RESULT_TITLE);
    }

    public static void printExecuteResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf(GameMessage.RESULT_FORMAT, car.getCarName(), getMoveGraph(car.getMovementCount()));
        }
        System.out.printf(GameMessage.NEXT_LINE);
    }

    private static String getMoveGraph(Integer movementCount) {
        StringBuilder moveGraph = new StringBuilder();
        for (int i = 0; i < movementCount; i++) {
            moveGraph.append(GameMessage.HYPHEN);
        }
        return moveGraph.toString();
    }

    public static void printExceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printFinalWinners(WinnerCars winnerCars) {
        System.out.printf(GameMessage.FINAL_WINNER_FORMAT, winnerCars.getWinnerNames());
    }
}
