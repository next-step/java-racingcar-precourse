package racingcar.result;

import racingcar.car.Car;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class RacingResult {

    private final List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = requireNonNull(cars, "cars");
    }

    public static RacingResult of(List<Car> cars) {
        return new RacingResult(cars);
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(cars);
    }
}
