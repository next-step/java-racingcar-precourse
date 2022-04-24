package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Lineup {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getAt(int index) {
        return cars.get(index);
    }

    public int numberOfCars() {
        return cars.size();
    }

    public RacingReport race(MovingConditions conditions) {
        assertConditions(conditions);

        RacingReport racingReport = new RacingReport();
        for(Car car : cars) {
            MovingCondition condition = conditions.conditionOf(car);
            Distance distance = car.move(condition);
            racingReport.write(car, distance);
        }

        return racingReport;
    }

    private void assertConditions(MovingConditions conditions) {
        if (conditions.numberOfConditions() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }
}
