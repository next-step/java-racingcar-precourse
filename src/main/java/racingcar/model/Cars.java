package racingcar.model;

import racingcar.model.input.CarName;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName.getName()));
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
