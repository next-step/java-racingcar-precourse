package com.game.racingcar.car.impl;

import com.game.racingcar.car.Car;
import com.game.racingcar.car.input.AccelPower;
import com.game.racingcar.car.input.CarName;
import com.game.racingcar.car.input.CarOption;
import com.game.racingcar.car.input.Position;

public class RacingCar implements Car {

    private final CarOption carOption;

    private CarName carName;
    private Position position = new Position();

    private RacingCar(CarOption carOption, CarName carName) {
        this.carOption = carOption;
        this.carName = carName;
    }

    public static Car of(CarName carName){
        return new RacingCar(new CarOption(), carName);
    }

    @Override
    public void move(AccelPower accelPower) {
        if (isPossibleMove(accelPower)) {
            goForward();
        }
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public long getMovingDistance() {
        return this.position.getX();
    }

    @Override
    public void printPosition() {
        System.out.println(carName.getName() + " : " + position.getPositionGraphString());
    }

    private void goForward() {
        position.moveRight();
    }

    private boolean isPossibleMove(AccelPower accelPower) {
        return accelPower.getPower() >= carOption.getMinPowerForMove();
    }


    @Override
    public int compareTo(Car car) {
        // TODO Auto-generated method stub
        long myDistance = this.getMovingDistance();
        long targetDistance = car.getMovingDistance();

        if (myDistance == targetDistance) return 0;
        else if (myDistance > targetDistance) return 1;
        else return -1;
    }

    @Override
    public String getCarName() {
        return this.carName.getName();
    }
}
