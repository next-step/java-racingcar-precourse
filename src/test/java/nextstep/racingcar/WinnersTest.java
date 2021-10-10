package nextstep.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.move.RandomMovingStrategy;

class WinnersTest {

	@DisplayName("승리한 자동차들의 이름을 콤마로 구분해 출력한다. (승리자가 한명)")
	@Test
	void toString_one_winner() {
		final Winners winners = new Winners(Collections.singletonList(
			new RacingCar("pobi", 1, RandomMovingStrategy.getInstance())));

		// when then
		assertEquals("pobi", winners.toString());
	}

	@DisplayName("승리한 자동차들의 이름을 콤마로 구분해 출력한다. (승리자 두명)")
	@Test
	void toString_two_winners() {
		// given
		final Winners winners = new Winners(Arrays.asList(
			new RacingCar("honux", 1, RandomMovingStrategy.getInstance()),
			new RacingCar("crong", 1, RandomMovingStrategy.getInstance())));

		// when then
		assertEquals("honux,crong", winners.toString());
	}

	@DisplayName("승리한 자동차들을 가져온다.")
	@Test
	void getWinners() {
		// given
		final RacingCars racingCars = new RacingCars(Arrays.asList(
			new RacingCar("pobi", 1, RandomMovingStrategy.getInstance()),
			new RacingCar("honux", 2, RandomMovingStrategy.getInstance()),
			new RacingCar("crong", 2, RandomMovingStrategy.getInstance())));

		// when
		final Winners winners = Winners.getWinners(racingCars);

		// then
		assertEquals(winners, new Winners(Arrays.asList(
			new RacingCar("honux", 2, RandomMovingStrategy.getInstance()),
			new RacingCar("crong", 2, RandomMovingStrategy.getInstance()))));
	}
}