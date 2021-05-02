package com.game.racingcar.car;

import com.game.racingcar.car.input.AccelPower;
import com.game.racingcar.car.input.Position;

public interface Car {
    void move(AccelPower accelPower);
    Position getPosition();
    void printPosition();
}
