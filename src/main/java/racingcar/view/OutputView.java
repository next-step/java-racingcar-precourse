package racingcar.view;

import static racingcar.type.GameMessageType.GAME_RESULT;
import static racingcar.type.GameMessageType.INPUT_CAR_NAME;
import static racingcar.type.GameMessageType.INPUT_TRY_COUNT;
import static racingcar.type.GameMessageType.VICTORY;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.VictoryCars;

public class OutputView {

    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public static void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT.getMessage());
    }

    public static void printGameResult() {
        System.out.println(GAME_RESULT.getMessage());
    }

    public static void printRacingCar(Cars cars) {
        for (Car car : cars.getCars()) {
            car.printMovingForward();
        }
        System.out.println();
    }

    public static void printVictory(VictoryCars victoryCars) {
        System.out.print(VICTORY.getMessage() + victoryCars.toString());
    }
}
