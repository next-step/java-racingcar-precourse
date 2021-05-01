package com.racingcar.util;

import com.racingcar.domain.MovingCondition;

import java.util.Random;

public class RacingCarRandomGenerator implements RandomGenerator {

    private final Random random = new Random();

    public MovingCondition generateMovingCondition(Integer seed) {
        return MovingCondition.of(generate(seed));
    }

    @Override
    public Integer generate(Integer seed) {
        return random.nextInt(seed);
    }
}
