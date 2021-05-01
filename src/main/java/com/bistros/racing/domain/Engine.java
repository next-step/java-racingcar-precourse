package com.bistros.racing.domain;

import java.util.Random;

public class Engine {
    private final Random core = new Random();
    static final int MIN_POWER = 4;

    public boolean canMove() {
        return canMove(core.nextInt(9));
    }

    public boolean canMove(int power) {
        return power >= MIN_POWER;
    }
}
