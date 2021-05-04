package com.game.racingcar.car;

import com.game.racingcar.car.input.AccelPower;

import java.util.ArrayList;
import java.util.List;

public abstract class Cars {
    protected List<Car> cars = new ArrayList<>();

    public abstract void moveAllCars();

    public abstract void printWholeCarsPosition();

    public abstract List<Car> getWinnerCars();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
