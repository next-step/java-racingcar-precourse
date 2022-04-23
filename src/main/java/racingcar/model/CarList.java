package racingcar.model;

import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public Car getCarByIndex(int index) {
        if (index < 0 || this.carList.size() <= index) {
            throw new IllegalArgumentException();
        }

        return this.carList.get(index);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
