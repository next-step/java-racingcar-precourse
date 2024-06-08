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
            for (Car car : cars) {
                car.move();
            }
        }
        return judgeWinners();
    }

}
