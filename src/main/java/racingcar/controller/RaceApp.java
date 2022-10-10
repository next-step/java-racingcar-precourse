package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.Race;
import racingcar.model.RandomStrategy;
import racingcar.view.Input;
import racingcar.view.Output;

import static racingcar.util.Payload.EXECUTION_RESULT;

public class RaceApp {
    public void play() {
        Cars cars = Input.scanCars();
        int tryNumber = Input.scanTryNumber();
        Race race = new Race(new RandomStrategy(), cars);
        Output.println(EXECUTION_RESULT);
        for (int i = 0; i < tryNumber; i++) {
            race.rolls();
            Output.printCars(race.cars());
        }
        GameResult gameResult = race.yieldFinalResult();
        Output.printWinners(gameResult);
    }
}
