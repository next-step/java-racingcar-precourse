package racingcar.controller;

import racingcar.model.race.Race;

public class RaceController {
    private final Race race;

    public RaceController() {
        race = new Race();
    }

    public void start() {
        inputCars();
        inputNumberOfAttemptMove();
        startRace();
    }

    private void inputCars() {
        try {
            race.initCars();
            race.inputCars();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCars();
        }
    }

    private void inputNumberOfAttemptMove() {
        try {
            race.inputNumberOfAttemptMove();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputNumberOfAttemptMove();
        }
    }

    private void startRace() {
        race.start();
    }
}
