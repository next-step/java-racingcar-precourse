package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class racingCars {
    private final List<racingCar> cars;
    public racingCars(List<racingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }
    public List<racingCar> getCars() {
        return cars;
    }
}
