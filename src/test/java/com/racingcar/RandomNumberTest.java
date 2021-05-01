package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomNumberTest {

	private static final int ENOUGH_TEST_COUNT = 10_000;

	@RepeatedTest(ENOUGH_TEST_COUNT)
	void 랜덤_숫자_0_9_사이의_숫자인지_테스트() {
		RandomNumber randomNumber = RandomNumber.create();

		assertThat(randomNumber.getValue()).isBetween(0, 9);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 10})
	@DisplayName("생성된 숫자가 0-9사이의 숫자가 아닌 경우 예외 발생")
	void 랜덤_숫자_0보다_작은_수_생성시_예외_테스트(Integer input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new RandomNumber(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 9})
	@DisplayName("랜덤 숫자 경계값 테스트")
	void 랜덤_숫자_경계값_테스트(Integer input) {
		assertThatNoException().isThrownBy(() -> new RandomNumber(input));
	}
}
