package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int numberOfAttempts;
    private final Random random = new Random();

    public RacingGame(String[] carNames, int numberOfAttempts) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.numberOfAttempts = numberOfAttempts;
    }

    public void play() {
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) {
                    car.move();
                }
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
