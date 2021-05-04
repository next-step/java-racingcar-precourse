package com.racingcar.util;

import com.racingcar.domain.MovingCondition;

import java.util.Random;

public class RacingCarRandomGenerator implements RandomGenerator<MovingCondition> {

    private final Random random = new Random();

    @Override
    public MovingCondition generate(Integer seed) {
        return MovingCondition.of(random.nextInt(seed));
    }
}
