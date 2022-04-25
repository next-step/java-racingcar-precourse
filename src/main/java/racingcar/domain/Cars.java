package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return findWinners(getMaxPosition());
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> printCurrentPosition() {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.printCurrentPosition());
        }
        return result;
    }

    private List<Car> findWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(maxPosition, winners, car);
        }

        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private void addWinner(Position maxPosition, List<Car> winners, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }
}
