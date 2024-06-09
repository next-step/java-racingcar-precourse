package model;

import java.util.List;
import java.util.stream.Collectors;
import utils.Utils;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void start() {
        cars.forEach(Car -> Car.move(Utils.getRandomNumber()));
    }

    public List<Car> judgeWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
