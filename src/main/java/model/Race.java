package model;

import java.util.List;
import java.util.Random;
import view.OutputView;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private static final int FORWARD_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random(); // static final로 변경

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
            OutputView.printRaceStatus(cars); // 출력 로직을 외부로 이동
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            if (RANDOM.nextInt(RANDOM_BOUND) >= FORWARD_THRESHOLD) {
                car.move();
            }
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
}
