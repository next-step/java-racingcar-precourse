package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingOrganizer {

    public static List<Car> createCars(String rawNames) {
        String[] names = rawNames.split(",");

        List<Car> cars = new ArrayList<>();
        for(String name: names)
            cars.add(new Car(name));
        return cars;
    }
}
