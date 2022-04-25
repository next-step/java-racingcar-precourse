package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public static List<Car> registerCars(String nameInput) {
        String[] names = CarName.splitNames(nameInput);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
