package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public void move() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public List<Car> findWinners() {
        int max = 0;
        for (Car car : cars) {
            max = car.getPosition().getMaxPosition(max);
        }
        Position maxPosition = new Position(max);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            winners = isWinner(winners, car, maxPosition);
        }
        return Collections.unmodifiableList(winners);
    }

    public List<Car> isWinner(List<Car> winners, Car car, Position maxPosition) {
        if (car.getPosition().equals(maxPosition)) {
            winners.add(car);
        }
        return winners;
    }
}
