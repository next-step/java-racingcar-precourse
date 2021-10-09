package racinggame.domain;

import racinggame.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final String NAME_SPLIT_REGEX = ",";
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move(final MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public Cars(final String names) {
        List<Car> cars = initCars(names);
        this.cars = Collections.unmodifiableList(cars);
    }

    private List<Car> initCars(final String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(NAME_SPLIT_REGEX)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
