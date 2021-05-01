package domain;

import java.util.Set;

public class Cars {
    Set<Car> cars;

    public Cars(Set<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            movingStrategy.move(car);
        }
    }
}
