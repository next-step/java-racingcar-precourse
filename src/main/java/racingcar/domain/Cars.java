package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void racing() {
        for (Car car : cars) {
            car.moveForward(new RandomMovingStrategy());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
