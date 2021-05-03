package com.racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

	@DisplayName("RacingCar 객체 equals 테스트")
	@Test
	public void testEquals(){
		RacingCar a = new RacingCar("test");
		RacingCar b = new RacingCar("test");

		assertEquals(a,b);
	}

}