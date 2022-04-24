package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private static final int COMPARE_VALUE = 0;
    private final List<Car> cars;

    private Cars(List<Car> cars) {

        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(Names names) {
        return new Cars(names.defaultPositionCars());
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> moveCars = cars.stream().map(car -> car.moveOrStop(moveStrategy))
                .collect(Collectors.toList());

        return from(moveCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Names winnerNames() {
        Car winPosition = winnerPositionCar();
        List<Name> names = new ArrayList<>();
        for (Car car : cars) {
            addNamesWithEqualPosition(winPosition, names, car);
        }
        return Names.from(names);
    }

    private Car winnerPositionCar() {
        Car winner = null;
        for (Car car : cars) {
            winner = carWithHigherPosition(winner, car);
        }
        return winner;
    }

    private Car carWithHigherPosition(Car winner, Car car) {
        if (winner == null) {
            return car;
        }

        if (winner.compareTo(car) < COMPARE_VALUE) {
            return car;
        }

        return winner;
    }

    private void addNamesWithEqualPosition(Car winPosition, List<Name> names, Car car) {
        if (car.equalsPosition(winPosition)) {
            names.add(car.getName());
        }
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
