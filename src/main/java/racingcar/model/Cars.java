package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] names, MovableStrategy movableStrategy) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(Car.of(name, movableStrategy));
        }

        return new Cars(cars);
    }

    public int carsSize() {
        return cars.size();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public int totalCurPosition() {
        int totalCurPosition = 0;

        for (Car car : cars) {
            totalCurPosition += car.curPosition();
        }

        return totalCurPosition;
    }

    public String findWinners(int round) {
        StringJoiner joiner = new StringJoiner(",");

        for (Car car : cars) {
            joiner = findWinner(car, round, joiner);
        }

        return joiner.toString();
    }

    public StringJoiner findWinner(Car car, int round, StringJoiner joiner) {
        if (car.isWinner(round)) {
            String name = car.getName();
            joiner.add(name);
        }

        return joiner;
    }

    public List<Car> cars() {
        return cars;
    }
}
