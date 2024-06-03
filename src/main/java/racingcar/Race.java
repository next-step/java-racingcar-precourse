package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final int tryCount;

    public Race(String[] carNames, int tryCount) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        if (tryCount <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        this.tryCount = tryCount;
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                int randomNumber = RandomNumberGenerator.generate();
                car.move(randomNumber);
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
