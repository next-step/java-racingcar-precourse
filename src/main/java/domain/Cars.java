package domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            movingStrategy.move(car);
        }
    }

}
