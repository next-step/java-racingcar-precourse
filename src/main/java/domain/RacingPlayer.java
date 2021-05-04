package domain;

import domain.strategy.RacingCarStrategy;

import java.util.ArrayList;
import java.util.List;

import static util.CarRacingConstants.RACING_MOVING_NUMBER_MAX;
import static util.CarRacingConstants.RACING_MOVING_NUMBER_MIN;

import util.*;

public class RacingPlayer {

    private static List<Car> carList;
    private static List<String> winners;
    private Car tmpCar;

    public RacingPlayer() {
        carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public RacingPlayer(List<String> carNameList) {
        carList = new ArrayList<>();
        for (String carName : carNameList) {
            tmpCar = new Car(carName);
            tmpCar.setMovableStrategy(new RacingCarStrategy());
            carList.add(tmpCar);
        }
    }

    public List<String> whoIsWinner() {
        winners = new ArrayList<>();
        int maxPos = maxPosition();
        for (Car car : carList) {
            if (car.getPos() == maxPos) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    public int maxPosition() {
        int maxValue = 0;
        for (Car car : carList) {
            if (maxValue < car.getPos()) {
                maxValue = car.getPos();
            }
        }
        return maxValue;
    }

    public void turn() {
        for (Car target : carList) {
            target.move(NumberUtils.create(RACING_MOVING_NUMBER_MIN, RACING_MOVING_NUMBER_MAX));
        }
    }


}
