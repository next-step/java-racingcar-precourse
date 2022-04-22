package racingcar.game.car;

import racingcar.game.util.AbstractImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Cars extends AbstractImmutableList<Car> {
    public Cars() {
        super();
    }

    public Cars(Car car) {
        super(car);
    }

    public Cars(Car... cars) {
        super(cars);
    }

    public Cars(List<Car> cars) {
        super(new ArrayList<>(cars));
    }

    public Cars(Cars cars, Car... more) {
        super(cars.list, more);
    }

    @Override
    public String toString() {
        return String.join(", ", map(car -> car.getName() + ":" + car.getDistance().get()));
    }
}
