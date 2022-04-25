package racingcar.model;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race(TotalLaps totalLaps) {
        for (int i = 0, length = totalLaps.totalLaps(); i < length; i++) {
            race();
        }
    }

    public Winners winners() {
        return new Winners(cars);
    }

    private void race() {
        for (Car car : cars) {
            car.move();
        }
        System.out.println();
    }
}
