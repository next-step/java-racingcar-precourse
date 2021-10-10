package nextstep.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.move.RandomMovingStrategy;

public class RacingCarsTest {

	private RacingCars racingCars;

	@BeforeEach
	void setUp() {
		final RacingCar pobi = new RacingCar("pobi", 1, RandomMovingStrategy.getInstance());
		final RacingCar honux = new RacingCar("honux", 2, RandomMovingStrategy.getInstance());
		final RacingCar crong = new RacingCar("crong", 3, RandomMovingStrategy.getInstance());
		final RacingCar sjlee = new RacingCar("sjlee", 3, RandomMovingStrategy.getInstance());

		racingCars = new RacingCars(Arrays.asList(pobi, honux, crong, sjlee));
	}

	@DisplayName("자동차들의 위치 중 가장 큰 위치를 반환한다.")
	@Test
	void getGreatestPosition() {
		// given

		// when then
		assertEquals(new Position(3), racingCars.getGreatestPosition());
	}

}
