package racinggame.domain;

public class Racing {

    private Cars cars;
    private int attemptCount;

    public Racing(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Cars start() {
        cars.gameStart(attemptCount);
        return cars;
    }

    public Cars carsResult() {
        return cars;
    }
}
