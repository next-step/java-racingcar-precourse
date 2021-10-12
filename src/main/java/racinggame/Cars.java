package racinggame;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cats) {
        this.cars = cars;
    }

    public Car findCar(int carNumber) {
        return cars.get(carNumber);
    }

}
