package com.game.racingcar.car;

import com.game.racingcar.car.input.AccelPower;
import com.game.racingcar.car.input.CarName;
import com.game.racingcar.car.input.Position;

public interface Car extends Comparable<Car> {
    void move(AccelPower accelPower);

    Position getPosition();

    long getMovingDistance();

    void printPosition();

    int compareTo(Car car);

    String getCarName();
}
