package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {

    private CarsFactory() {
        throw new IllegalStateException("Not supported");
    }

    public static List<Car> of(final String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
