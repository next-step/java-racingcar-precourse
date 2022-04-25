package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void move() {
        cars.move();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

    public List<String> printCurrentPosition() {
        return cars.printCurrentPosition();
    }
}
