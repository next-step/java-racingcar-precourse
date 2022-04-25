package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public static Cars empty() {
        return new Cars();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> toList() {
        return cars;
    }

    public int size() {
        return this.cars.size();
    }
}
