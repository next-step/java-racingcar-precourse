package racingcar.racing;

import racingcar.car.Car;
import racingcar.car.CarName;

import java.util.List;

import static racingcar.ErrorMessage.ENTRY_NOT_VALID_SIZE;

public class Entry {
    private final static int MIN_ENTRY_SIZE = 2;

    private final List<Car> cars;

    public Entry(List<CarName> carNames) {
        this.cars = checkValidation(Car.toList(carNames));
    }

    public List<Car> getEntryList() {
        return this.cars;
    }

    private List<Car> checkValidation(List<Car> cars) {
        if (cars.size() < MIN_ENTRY_SIZE) {
            throw new IllegalArgumentException(ENTRY_NOT_VALID_SIZE);
        }
        return cars;
    }
}
