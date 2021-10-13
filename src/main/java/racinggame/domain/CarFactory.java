package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.getNames()) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
