package service;

import domain.Car;
import dto.CarName;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    List<Car> cars = new ArrayList<>();

    public void createCars(CarName carName) {
        cars = carName.getNameList().stream()
            .map(Car::new)
            .toList();
    }

    public void moveCars() {
        cars.forEach(Car::next);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinnerName() {
        int maxDistance = cars.stream()
            .mapToInt(Car::getDistance)
            .max()
            .orElseThrow();

        return cars.stream()
            .filter(car -> car.getDistance().equals(maxDistance))
            .map(Car::getName)
            .toList();
    }
}
