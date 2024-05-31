package model;

import java.util.*;

public class Race {
    private List<Car> carList;

    public Race() {
    }

    public Race(String[] names) {
        this.carList = Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public void racing() {
        for (Car car : carList) {
            moveEachCar(car);
        }
    }

    public void moveEachCar(Car car) {
        int randomNumber = generateRandomNumber();
        car.moveForward(randomNumber);
    }
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
