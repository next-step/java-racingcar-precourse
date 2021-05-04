package racingCar.domain;

import racingCar.view.TryResultsView;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private TryCount tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    public TryResultsView race() {
        List<TryResult> tryResults = cars.move();
        tryCount = tryCount.decrease();
        return new TryResultsView(tryResults);
    }

    public boolean availableGame() {
        return tryCount.isAvailableGame();
    }

    public Cars winnerCars() {
        return new Cars(cars.determineWinners());
    }
}
