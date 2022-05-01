package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.Round;
import racingcar.model.input.CarNames;

import static racingcar.model.GameInputReader.*;

public class GameController {

    public void play() {
        Cars cars = setUpCars();
        Round round = setUpRound();

        Race race = new Race(cars, round);
        race.start();
        race.finish();
    }

    private Cars setUpCars() {
        Cars cars;
        try {
            CarNames carNames = new CarNames(readRacingCarNames());
            cars = new Cars(carNames.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setUpCars();
        }
        return cars;
    }

    private Round setUpRound() {
        Round round;
        try {
            round = new Round(readRacingRounds());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setUpRound();
        }
        return round;
    }
}
