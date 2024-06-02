package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attemptCount;
    private final RandomMoveStrategy moveStrategy;

    public RacingGame(List<String> carNames, int attemptCount) {
        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        this.attemptCount = attemptCount;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void raceOnce() {
        for (Car car : cars) {
            car.move(moveStrategy.isMovable());
        }
    }

    public void race() {
        for (int i = 0; i < attemptCount; i++) {
            raceOnce();
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
