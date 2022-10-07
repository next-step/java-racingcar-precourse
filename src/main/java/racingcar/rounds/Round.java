package racingcar.rounds;

import racingcar.cars.Cars;

public class Round {

    private final Cars cars;
    private final int currentRoundCount;

    public Round(Cars cars, int currentRoundCount) {
        this.cars = cars;
        this.currentRoundCount = currentRoundCount;
    }

    public Cars getCars() {
        return cars;
    }

    public int getCurrentRoundCount() {
        return currentRoundCount;
    }
}
