package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int attempts;

    public RacingGame(String carNames, int attempts) {
        this.attempts = validateAttempts(attempts);
        initializeCars(carNames);
    }

    private void initializeCars(String carNames) {
        for (String name : carNames.split(",")) {
            cars.add(new Car(name.trim()));
        }
    }

    private int validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 회수는 1회 이상이어야 합니다.");
        }
        return attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            OutputHandler.printRoundResult(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return findWinners(maxPosition);
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    private List<String> findWinners(int maxPosition) {
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}