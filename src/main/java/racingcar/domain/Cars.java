package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String NAME_DELIMITER = ",";
    private final List<Car> values;

    public Cars(String input) {
        List<Car> cars = new ArrayList<>();

        for (String carName : input.split(NAME_DELIMITER)) {
            cars.add(new Car(carName));
        }

        this.values = cars;
    }

    public List<Car> getValues() {
        return values;
    }

    public void allCarsMove(MoveStrategy moveStrategy) {
        for (Car car : values) {
            car.move(moveStrategy);
        }
    }

    public int getLargestPositionAmongCars() {
        int max = 0;
        for (Car car : values) {
            max = Math.max(max, car.getPosition().getValue());
        }
        return max;
    }
}
