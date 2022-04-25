package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    private static final String DELIMITER = ",";

    public static Cars create(String carNames) {
        return new Cars(toCarList(carNames));
    }

    private static List<Car> toCarList(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : split(carNames)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static String[] split(String carNames) {
        return carNames.split(DELIMITER);
    }
}
