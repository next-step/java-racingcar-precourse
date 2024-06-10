package model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import util.RandomNumberGenerator;

public class RacingCarGame {

    private final List<Car> cars = new ArrayList<>();

    private final RandomNumberGenerator generator = new RandomNumberGenerator();;

    public RacingCarGame(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> playOneRound() {
        for (Car car : cars) {
            car.move(generator.generateRandomNumber());
        }

        return cars;
    }

    public List<Car> judgeWinners() {
        int winnerPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(NoSuchElementException::new);

        return cars.stream()
            .filter(car -> car.getPosition() == winnerPosition)
            .toList();
    }

}
