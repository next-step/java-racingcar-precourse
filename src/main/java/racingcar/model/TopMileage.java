package racingcar.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopMileage {

    private final int topMileage;

    public TopMileage(List<Car> cars) {
        this.topMileage = createTopMileage(cars);
    }

    public int topMileage() {
        return this.topMileage;
    }

    private int createTopMileage(List<Car> cars) {
        Car car = Collections.max(cars, Comparator.comparingInt(o -> o.mileage.mileage()));
        return car.mileage.mileage();
    }
}
