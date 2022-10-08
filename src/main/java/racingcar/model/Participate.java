package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.Constants.INIT_MOVE_COUNT;

public class Participate {

    public List<Car> addCar(String[] carName) {
        List<Car> cars = new ArrayList<>();

        for (String name : carName) {
            Car car = Car.participate(name, INIT_MOVE_COUNT);
            cars.add(car);
        }

        return cars;
    }
}
