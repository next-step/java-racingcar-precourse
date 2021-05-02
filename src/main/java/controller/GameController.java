package controller;

import racingcar.RacingCars;
import view.GameInput;
import view.GameOutput;

public class GameController {

    public static void main(String[] args) {
        GameOutput.printEnterCarNames();

        RacingCars racingCars = new RacingCars(GameInput.enterCarNames());

        GameOutput.printAttemptCount();

        int attemptCount = GameInput.enterAttemptCount();

        GameOutput.printGameResultComment();

        for (int i = 0; i < attemptCount; i++) {
            racingCars.moveForward();
            racingCars.getRacingCars().forEach(racingCar -> GameOutput.printTravelDistanceForCar(racingCar.getName(), racingCar.getDistance()));
            GameOutput.crlf();
        }
    }

}
