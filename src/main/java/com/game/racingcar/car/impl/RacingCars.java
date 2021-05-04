package com.game.racingcar.car.impl;

import com.game.racingcar.car.Car;
import com.game.racingcar.car.Cars;
import com.game.racingcar.car.input.AccelPower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCars extends Cars {
    @Override
    public void moveAllCars() {
        for (int i = 0; i < this.cars.size(); i++) {
            this.cars.get(i).move(AccelPower.getRandomAccelPower());
        }
    }

    @Override
    public void printWholeCarsPosition() {
        for (Car car :
                this.cars) {
            car.printPosition();
        }
        this.printEnter();
    }

    private void printEnter() {
        System.out.println();
    }

    @Override
    public List<Car> getWinnerCars() {
        List<Car> winners = new ArrayList<>();

        // 오름차순 정렬
        List<Car> sortedCars = getCarsSortedByMovingDistanceDesc();

        for (int i = 0; i < sortedCars.size(); i++) {
            addWinner(winners, sortedCars.get(i));
        }

        return winners;
    }

    private void addWinner(List<Car> winners, Car car) {
        if (isWinner(winners, car)) {
            winners.add(car);
        }
    }

    private boolean isWinner(List<Car> winners, Car car) {
        Car maxMovingCar = winners.isEmpty() ? null : Collections.max(winners);

        if (maxMovingCar == null) {
            return true;
        }

        if (maxMovingCar.getMovingDistance() <= car.getMovingDistance()) {
            return true;
        }

        return false;
    }

    private List<Car> getCarsSortedByMovingDistanceDesc() {
        List<Car> sortedCars = new ArrayList<>();
        sortedCars.addAll(cars);
        sortedCars.sort(Comparator.reverseOrder());
        return sortedCars;
    }
}
