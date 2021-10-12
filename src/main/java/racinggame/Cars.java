package racinggame;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car findCar(int carNumber) {
        return cars.get(carNumber);
    }

}
