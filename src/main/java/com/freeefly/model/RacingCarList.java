package com.freeefly.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {

    private List<RacingCar> cars = new ArrayList<>();

    public List<RacingCar> getCars() {
        return cars;
    }

    public void addCar(String name) {
        getCars().add(new RacingCar(name));
    }

    /**
     * 우승한 자동차 이름을 리턴
     *
     * @return
     */
    public List<String> getWinnerNames() {
        List<String> winners = new ArrayList<>();
        getCars().forEach(car ->
                getWinnerName(winners, car));
        return winners;
    }

    private void getWinnerName(List<String> winners, RacingCar car) {
        if (car.isWinner()) {
            winners.add(car.getName());
        }
    }

    /**
     * 승자 검증
     */
    public void validateWinners() {
        int max = 0;
        for (RacingCar car : getCars()) {
            max = findWinnerProceedCount(car, max);
        }

        for (RacingCar car : getCars()) {
            car.winBy(max);
        }
    }

    private int findWinnerProceedCount(RacingCar car, int max) {
        return Math.max(car.getProceedCount(), max);
    }


}
