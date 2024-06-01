package service;

import domain.Car;
import dto.CarName;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    List<Car> cars = new ArrayList<>();

    public void createCars(CarName carName) {
        cars = carName.nameList().stream()
                .map(Car::new)
                .toList();
    }

    public void moveCars() {
        cars.forEach(Car::next);
    }

    public List<Car> getCars() {
        return cars;
    }
}
