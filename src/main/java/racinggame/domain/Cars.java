package racinggame.domain;

import java.util.*;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars(ArrayList<String> carNames) {
        this.cars = new ArrayList<>();
        setCars(carNames);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    private void setCars(ArrayList<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
