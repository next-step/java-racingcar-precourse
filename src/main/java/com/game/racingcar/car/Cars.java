package com.game.racingcar.car;

import java.util.ArrayList;
import java.util.List;

public abstract class Cars {
    protected List<Car> cars = new ArrayList<>();

    public abstract void printWholeCarsPosition();

    public abstract List<Car> getWinners();

    public void addCar(Car car) {
        cars.add(car);
    }

}
