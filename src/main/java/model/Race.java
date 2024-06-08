package model;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<String> carNames, int rounds) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.rounds = rounds;
    }

    public List<Car> start() {
        for (int i = 0; i < rounds; i++) {
            cars.forEach(Car::move);
        }
        return judgeWinners();
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
}
