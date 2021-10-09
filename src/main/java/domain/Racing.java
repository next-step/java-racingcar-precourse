package domain;

public class Racing {

    private Cars cars;
    private int attemptCount;

    public Racing(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void start() {
        cars.gameStart(attemptCount);
    }

    public Cars carsResult() {
        return cars;
    }
}
