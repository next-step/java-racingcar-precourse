package com.racingcar.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MockMovingStrategy implements RacingCarMovingStrategy {

	private final int seedValue;

	@Override
	public MovingSeed generate() {
		return new MovingSeed(seedValue);
	}
}
