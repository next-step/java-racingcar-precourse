package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Activity {
    private final List<Car> cars;

    public Activity(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> value() {
        return Collections.unmodifiableList(this.cars);
    }
}
