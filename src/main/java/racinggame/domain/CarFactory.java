package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static Cars from(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName name : carNames.getNames()) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
