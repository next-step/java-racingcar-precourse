package racingCar.domain;

public class RacingGame {

    private final Cars cars;
    private TryCount tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    public void race() {
        cars.move();
        tryCount = tryCount.decrease();
    }

    public boolean availableGame() {
        return tryCount.isAvailableGame();
    }
}
