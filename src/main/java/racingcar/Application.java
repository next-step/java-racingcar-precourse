package racingcar;

import racingcar.controllers.RaceController;
import racingcar.models.RacingCars;
import racingcar.models.RacingTurn;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController();

        RacingCars cars = raceController.entry();
        RacingTurn turn = raceController.enterRacingTurn();

        raceController.hold(cars, turn);
    }
}
