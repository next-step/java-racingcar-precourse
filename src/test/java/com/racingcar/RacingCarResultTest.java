package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarResultTest {

	private RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = RacingCar.of(Name.of("test1"));
	}

	@Test
	void 위치_0인_경우_출력_테스트() {
		racingCar.moveForwardIfMoveable(new RandomNumber(0));

		assertThat(RacingCarResult.of(racingCar).toString())
			.isEqualTo("test1 : ");
	}

	@Test
	void 위치_3인_경우_출력_테스트() {
		racingCar.moveForwardIfMoveable(new RandomNumber(4));
		racingCar.moveForwardIfMoveable(new RandomNumber(4));
		racingCar.moveForwardIfMoveable(new RandomNumber(4));

		assertThat(RacingCarResult.of(racingCar).toString())
			.isEqualTo("test1 : ---");
	}
}