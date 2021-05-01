package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberTest {

	private static final int ENOUGH_TEST_COUNT = 10_000;

	@RepeatedTest(ENOUGH_TEST_COUNT)
	void 랜덤_숫자_0_9_사이의_숫자인지_테스트() {
		RandomNumber randomNumber = RandomNumber.create();

		assertThat(randomNumber.getValue()).isBetween(0, 9);
	}
}
