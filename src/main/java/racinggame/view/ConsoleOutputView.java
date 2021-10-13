package racinggame.view;

import racinggame.model.RacingCarGame;
import java.util.List;

import static racinggame.constants.Messages.*;
import static racinggame.constants.RacingCarConstants.CAR_MOVE_UNIT;

public class ConsoleOutputView {
    private static RacingCarGame racingCarGameResult;

    public static void displayGameResult(RacingCarGame gameResult, int userInputMoveTryCount) {
        racingCarGameResult = gameResult;
        System.out.println();
        System.out.println(GAME_RESULT);
        displayRacingCarStepByStepPosition(userInputMoveTryCount);
        displayRacingCarGameResult();
    }

    private static void displayRacingCarStepByStepPosition(int moveTryCount) {
        for (int i = 0; i < moveTryCount; i++) {
            moveRacingCarsStepByStep();
            System.out.println();
        }
    }

    private static void moveRacingCarsStepByStep() {
        racingCarGameResult.getRacingCarStepByPosition().forEach((racingCar, stepByPosition) -> {
            System.out.print(String.format(CAR_NAME_COLON.getMessage(), racingCar.getRacingCarName()));
            diplayConvertRacingCarMoveUnit(racingCar.getRacingCarPosition());
        });
    }

    private static void diplayConvertRacingCarMoveUnit(int positionNum) {
        for (int i = 0; i < positionNum; i++) {
            System.out.print(CAR_MOVE_UNIT);
        }
        System.out.println();
    }

    private static void displayRacingCarGameResult() {
        List<String> winners = racingCarGameResult.getWinners();
        String winnersResult = String.join(",", winners);
        System.out.println(String.format(GAME_WINNERS.getMessage(), winnersResult));
    }
}
