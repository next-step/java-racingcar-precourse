package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void race(int trials) {
        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
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
