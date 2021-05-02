package com.game.racingcar.car.input;

public class CarName {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        if (!isValidCarName(name)) {
            return null;
        }
        return new CarName(name);
    }

    private static boolean isValidCarName(String name) {
        if (name.length() > MAX_LENGTH_OF_CAR_NAME) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
