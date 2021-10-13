package racinggame.domain;

import java.util.*;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(CarNames carNames) {
        this.cars = new ArrayList<>();
        setCars(carNames);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    private void setCars(CarNames carNames) {
        for (CarName carName : carNames.getCarNames()) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
