package model;

import util.RandomUtil;

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
        int randomNumber = RandomUtil.generateRandomNumber();
        car.moveForward(randomNumber);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
