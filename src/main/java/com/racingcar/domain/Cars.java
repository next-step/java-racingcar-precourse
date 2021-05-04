package com.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Winners electWinners() {
        List<Winner> winners = new ArrayList<>();
        List<Car> sortedCars = new ArrayList<>(cars);

        sortedCars.sort(Collections.reverseOrder());
        Car maxPositionCar = sortedCars.get(0);

        for (Car sortedCar : sortedCars) {
            addToWinners(winners, sortedCar, maxPositionCar);
        }

        return Winners.of(winners);
    }

    private void addToWinners(List<Winner> winners, Car targetCar, Car maxPositionCar) {
        if (targetCar.isSamePosition(maxPositionCar)) {
            winners.add(targetCar.winner());
        }
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
