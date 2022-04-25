package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> carList() {
        return Collections.unmodifiableList(cars);
    }
}
