package racingcar.model;

public class Race {
    private final Cars cars;
    private final RollStrategy rollStrategy;

    public Race(RollStrategy rollStrategy, Cars cars) {
        this.rollStrategy = rollStrategy;
        this.cars = cars;
    }

    public RollResult roll(Car car) {
        return this.rollStrategy.roll(car);
    }

    public void rolls() {
        for (Car car : this.cars) {
            roll(car);
        }
    }

    public GameResult yieldFinalResult() {
        return this.cars.yieldFinalResult();
    }

    public Cars cars() {
        return this.cars;
    }
}