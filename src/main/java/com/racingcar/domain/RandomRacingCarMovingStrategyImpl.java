package com.racingcar.domain;

import java.util.Random;

public class RandomRacingCarMovingStrategyImpl implements RacingCarMovingStrategy {
	private static final int VALUE_BOUND = 10;

	private final Random random;

	public RandomRacingCarMovingStrategyImpl() {
		random = new Random();
	}

	@Override
	public MovingSeed generate() {
		return new MovingSeed(random.nextInt(VALUE_BOUND));
	}
}
