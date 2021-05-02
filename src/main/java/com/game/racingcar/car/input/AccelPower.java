package com.game.racingcar.car.input;

public class AccelPower {
    public int getPower() {
        return power;
    }

    private int power;

    private AccelPower(int power) {
        this.power = power;
    }

    public static AccelPower of(int power){
        return new AccelPower(power);
    }
}
