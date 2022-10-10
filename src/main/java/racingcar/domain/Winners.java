package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Car car : cars) {
            builder.append(builder.length() != 0 ? ", " : "").append(car.getName().getName());
        }

        return builder.toString();
    }

    public static Winners of(List<Car> cars) {
        return new Winners(cars);
    }
}
