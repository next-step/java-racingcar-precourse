package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.model.WinningRacingCar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.RacingGameMessage.RACING_CAR_GAME_RESULT;
import static racingcar.constant.RacingGameMessage.RACING_CAR_MATCH_FINAL_WINNER;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String RACING_CAR_MOVE_ROOT = "-";
    private static final String SEPARATOR = " : ";

    public static void printResultMessage() {
        printLine();
        printMessage(RACING_CAR_GAME_RESULT);
    }

    public static void printProgress(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            printMessage(racingCar.getRacingCarName().getName() + SEPARATOR + printRacingCarMovingRoot(racingCar));
        }
    }

    public static void printWinners(List<WinningRacingCar> winners) {
        List<String> carNames = new ArrayList<>();
        for (WinningRacingCar winner : winners) {
            carNames.add(winner.getRacingCar().getRacingCarName().getName());
        }
        printMessage(RACING_CAR_MATCH_FINAL_WINNER + String.join(DELIMITER, carNames));
    }

    private static String printRacingCarMovingRoot(RacingCar racingCar) {
        StringBuilder buffer = new StringBuilder();
        for (int i = racingCar.getRacingCarPosition().get(); i > 0; i--) {
            buffer.append(RACING_CAR_MOVE_ROOT);
        }
        return buffer.toString();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLine() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

}
