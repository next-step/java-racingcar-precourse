package racingcar.game.car;

import racingcar.game.util.AbstractMutableList;

import java.util.ArrayList;
import java.util.Collection;

public class Cars extends AbstractMutableList<Car> {
    public Cars() {
        super();
    }

    public Cars(Car car) {
        super(car);
    }

    public Cars(Cars cars, Car... more) {
        super(cars.list, more);
    }

    public Cars(Collection<Car> cars) {
        super(new ArrayList<>(cars));
    }

    @Override
    public String toString() {
        return String.join(", ", map(car -> car.getName() + ":" + car.getDistance().get()));
    }
}
