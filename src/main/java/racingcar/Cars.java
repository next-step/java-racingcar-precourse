package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(CarNames carNames) {
        List<Car> carList = new ArrayList<>();

        for (CarName carName : carNames.getCarNames()) {
            carList.add(Car.createCar(carName));
        }

        this.cars = carList;
    }

    public static Cars createCars(CarNames carNames) {
        return new Cars(carNames);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
