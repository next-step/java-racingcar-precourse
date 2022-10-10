package racingcar.referee.domain;

import racingcar.car.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinningCars {

    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        this.cars.add(car);
    }

    public int size() {
        return this.cars.size();
    }

    public List<Car> cars() {
        return this.cars;
    }
}
