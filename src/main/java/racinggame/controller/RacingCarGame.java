package racinggame.controller;

import racinggame.domain.*;
import racinggame.view.RacingCarOutput;
import racinggame.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void run() {
        startGame();
    }

    public void startGame() {
        List<CarName> carNames = inputRacingCarName();
        Cars cars = new Cars(createCars(carNames));
        AttemptCount attemptCount = getAttemptCount();
        race(cars, attemptCount);
    }

    private void race(Cars cars, AttemptCount attempCount) {
        RacingCarView.printRaceResult();
        String winner = cars.race(attempCount);
        RacingCarView.printFinalWinner(winner);
    }

    private List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private AttemptCount getAttemptCount() {
        AttemptCount attemptCount;
        try {
            attemptCount = new AttemptCount(inputAttemptCount());
        } catch (IllegalArgumentException e) {
            RacingCarOutput.println(e.getMessage());
            return getAttemptCount();
        }

        return attemptCount;
    }

    private List<CarName> inputRacingCarName() {
        List<CarName> carNames;
        try {
            carNames = Delimiter.separateCarNames(RacingCarView.inputRacingCarName());
        } catch (IllegalArgumentException e) {
            RacingCarOutput.println(e.getMessage());
            return inputRacingCarName();
        }

        return carNames;
    }

    private String inputAttemptCount() {
        return RacingCarView.inputAttemptCount();
    }
}
