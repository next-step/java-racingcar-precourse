package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.List;

public class CarEntry {
    private List<Car> cars;

    public CarEntry() {
    }

    public CarEntry(List<Car> cars) {
        validateEntry(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateEntry(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_ENTRY);
        }
    }
}
