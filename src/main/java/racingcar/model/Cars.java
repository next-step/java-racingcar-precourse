package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    void addCar(Car car){
        this.cars.add(car);
    }
}
