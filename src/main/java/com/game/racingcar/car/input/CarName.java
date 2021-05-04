package com.game.racingcar.car.input;

import com.game.racingcar.car.input.exception.CarNameNotValidException;

public class CarName {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public static void isValidCarName(String name) {
        if (name.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new CarNameNotValidException();
        }
    }

    public String getName() {
        return name;
    }
}
