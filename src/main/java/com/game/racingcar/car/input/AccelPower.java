package com.game.racingcar.car.input;

import com.game.utils.RandomUtil;

public class AccelPower {
    private int power;
    private static final int ACCEL_POWER_MIN = 0;
    private static final int ACCEL_POWER_MAX = 9;
    private AccelPower(int power) {
        this.power = power;
    }

    public static AccelPower of(int power) {
        return new AccelPower(power);
    }

    public static AccelPower getRandomAccelPower() {
        return AccelPower.of(RandomUtil.getRandomNumber(ACCEL_POWER_MIN, ACCEL_POWER_MAX));
    }

    public int getPower() {
        return power;
    }
}
