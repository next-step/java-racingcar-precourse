package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private static final int FORWARD_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;

    public Race(List<String> carNames) {
        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        initializeCars();
    }

    private void initializeCars() {
        for (Car car : cars) {
            car.initializePosition();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            moveCars();
            printRaceStatus();
        }
    }

    private void moveCars() {
        Random random = new Random();
        for (Car car : cars) {
            if (random.nextInt(RANDOM_BOUND) >= FORWARD_THRESHOLD) {
                car.move();
            }
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            StringBuilder status = new StringBuilder();
            status.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                status.append("-");
            }
            System.out.println(status.toString());
        }
        System.out.println(""); // 빈 줄로 회차 구분
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
}
