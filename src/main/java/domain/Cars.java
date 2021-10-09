package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String names) {
        List<Car> cars = new ArrayList<>();

        List<String> carNames = Arrays.asList(names.split(DELIMITER));

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.cars = cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
