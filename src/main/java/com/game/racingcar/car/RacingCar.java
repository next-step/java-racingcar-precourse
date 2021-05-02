package com.game.racingcar.car;

import com.game.racingcar.car.input.AccelPower;
import com.game.racingcar.car.input.CarName;
import com.game.racingcar.car.input.CarOption;
import com.game.racingcar.car.input.Position;

public class RacingCar implements Car {

    private final CarOption carOption;

    private CarName carName;
    private Position position = new Position();

    public RacingCar(CarOption carOption, CarName carName) {
        this.carOption = carOption;
        this.carName = carName;
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
    public void printPosition() {
        System.out.println(carName.getName() + " : " + position.getPositionGraphString());
    }

    private void goForward() {
        position.moveRight();
    }

    private boolean isPossibleMove(AccelPower accelPower) {
        return accelPower.getPower() >= carOption.getMinPowerForMove();
    }


}
