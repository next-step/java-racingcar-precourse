package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.Move;

public class Cars {

    private final List<Car> cars;

    private Cars() {
        this.cars = new ArrayList<>();
    }

    public static Cars of(final String[] names, final Move move) {
        Cars cars = new Cars();

        for (String name : names) {
            cars.cars.add(new Car(name, move));
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getResults() {
        return cars;
    }

    public Winners getWinners() {
        return Winners.of(this.cars);
    }
}
