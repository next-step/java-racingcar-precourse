package racingcar.factory;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private final static String SEPARATOR = ",";

    public Cars getCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(SEPARATOR)) {
            final Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }
}
