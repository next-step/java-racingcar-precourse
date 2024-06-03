package model;

import util.RandomNumGenerator;
import vo.Car;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class GameService {
    private final RandomNumGenerator generator;

    public GameService() {
        generator = new RandomNumGenerator();
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = generateNumber();
            move(car, randomNum);
        }
    }

    public void move(Car car, int number) {
        if (number >= 4) {
            car.addPosition();
        }
    }

    public List<Car> getCarWithMaxDistance(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 세팅된 자동차가 없습니다.");
        }

        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 최대 거리의 자동차를 찾을 수 없습니다."));
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int generateNumber() {
        return generator.getRandomInt();
    }
}
