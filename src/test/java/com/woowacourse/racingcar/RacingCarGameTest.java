package com.woowacourse.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.woowacourse.racingcar.RacingCarGame.RacingCar;;

public class RacingCarGameTest {
	@Test
	public void testCarClass() {
		RacingCarGame racingCarGame = new RacingCarGame();
		RacingCar car = racingCarGame.new RacingCar("±èº´Ã¶");
		
		assertEquals(car.getCarName(), "±èº´Ã¶");
		car.setCarName("ÀÌ½ÂÈñ");
		assertEquals(car.getCarName(), "ÀÌ½ÂÈñ");
		car.setMoveCnt();
		assertEquals(car.getMoveCnt(), 1);
	}
}
