package racingcar.domain;

public class RacingGame {

    private final Cars cars;
    private final AttemptCount attemptCount;

    public RacingGame(Cars cars, AttemptCount attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Winners run() {
        controls(cars);
        return cars.getWinners();
    }

    private void controls(Cars cars) {
        for (int i = 0; i < attemptCount.getValue(); i++) {
            cars.control();
        }
    }
}
