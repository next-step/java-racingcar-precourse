package racingcar.domain;

import static racingcar.constant.ErrorStatus.INVALID_CAR_OR_NUMBER;

public class Game {
    private final Cars cars;
    private final NumberOfAttempts numberOfAttempts;

    public Game(Cars cars, NumberOfAttempts numberOfAttempts) {
        validate(cars, numberOfAttempts);
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    private void validate(Cars cars, NumberOfAttempts numberOfAttempts) {
        if (cars == null || numberOfAttempts == null) {
            throw new IllegalArgumentException(INVALID_CAR_OR_NUMBER.getMessage());
        }
    }

    public boolean isContinue() {
        return numberOfAttempts.areRemain();
    }

    public void race() {
        Standards standards = Standards.getStandardsByRandom(cars.size());
        cars.tryToMove(standards);
        cars.print();
        numberOfAttempts.subtract();
    }

    public Cars getWinners() {
        return cars.getTheFarthest();
    }

}
