package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

	private RacingCar car;

	@BeforeEach
	void setUp() {
		car = RacingCar.of(Name.of("test1"));
	}

	@Test
	void 랜덤값이_4이상이면_전진() {
		RandomNumber randomNumber = new RandomNumber(4);

		car.moveForwardIfMoveable(randomNumber);

		assertThat(car.getLocation().getValue()).isEqualTo(1);
	}

	@Test
	void 랜덤값이_3이하면_멈춘다() {
		RandomNumber randomNumber = new RandomNumber(3);

		car.moveForwardIfMoveable(randomNumber);

		assertThat(car.getLocation().getValue()).isEqualTo(0);
	}

	@Test
	void 복합테스트_4이상_2_3이하_1_4이상_1() {
		car.moveForwardIfMoveable(new RandomNumber(4));
		car.moveForwardIfMoveable(new RandomNumber(9));
		car.moveForwardIfMoveable(new RandomNumber(3));
		car.moveForwardIfMoveable(new RandomNumber(5));

		assertThat(car.getLocation().getValue()).isEqualTo(3);
	}
}
