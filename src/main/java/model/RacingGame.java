package model;

import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int tryCount) {
        OutputView.printString();

        for (int i = 0; i < tryCount; i++) {
            cars.forEach(car -> car.move(getRandomNumber()));
            OutputView.printMoves(cars);
        }
        OutputView.printWinners(getWinners());
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo).orElse(0);
    }

    private List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = findWinners(maxPosition);

        return winners;
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }
}
