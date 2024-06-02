package model;

import java.util.List;
import java.util.ArrayList;
public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this.cars = createCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCars(String inputNames) {
        String[] names = inputNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name.trim());
            cars.add(car);
        }
        return cars;
    }

    public void runCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

}
