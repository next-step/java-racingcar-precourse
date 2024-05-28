package model;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            int randomValue = randomNumberGenerator.generate();
            car.move(randomValue);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
