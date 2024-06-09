package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(final Car... cars) {
        this.cars = Arrays.stream(cars).toList();
    }

    public Position highestPosition() {
        Position highestPosition = cars.get(0).position();

        for (Car car : cars) {
            if (car.position().isUpper(highestPosition)) {
                highestPosition = car.position();
            }
        }

        return highestPosition;
    }

    public Cars equalPosition(final Position position) {
        Car[] cars = this.cars.stream()
                .filter(car -> car.position().equals(position))
                .toArray(Car[]::new);

        return new Cars(cars);
    }

    public Cars forward(final ForwardRule forwardRule, final PickNumberRule pickNumberRule) {
        Car[] forwardCars = this.cars.stream()
                .map(car -> {
                    if (forwardRule.isForward(pickNumberRule.pick())) {
                        return car.forward();
                    }
                    return car;
                }).toArray(Car[]::new);

        return new Cars(forwardCars);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
