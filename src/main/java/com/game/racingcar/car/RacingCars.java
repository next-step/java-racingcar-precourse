package com.game.racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCars extends Cars {
    @Override
    public void printWholeCarsPosition() {
        for (Car car :
                this.cars) {
            car.printPosition();
        }
    }

    @Override
    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();

        // 오름차순 정렬
        List<Car> sortedCars = getCarsSortedByMovingDistanceDesc();

        // TODO : 제거
        this.printWholeCarsPosition();

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

        System.out.println("============");
        System.out.println("max = " + maxMovingCar.getCarName());
        System.out.println("max = " + maxMovingCar.getMovingDistance());

        if (maxMovingCar.getMovingDistance() <= car.getMovingDistance()) {
            return true;
        }

        return false;
    }

    private List<Car> getCarsSortedByMovingDistanceDesc() {
        List<Car> sortedCars = new ArrayList<>();
        sortedCars.addAll(cars);
//        Collections.copy(sortedCars, cars);

        sortedCars.sort(Comparator.reverseOrder());

        return sortedCars;
    }
}
