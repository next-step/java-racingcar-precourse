package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class RacingGameTest {

	@Test
	void 지정된_랜덤값에_의한_결과_확인1() { // @checkstyle:ignore
		String carInput = "car1,car2,car3";
		CarEntries entries = new CarEntries(carInput);
		RacingTurn turn = new RacingTurn(4);

		RacingGame game = new RacingGame(entries, turn, size -> {
			return Arrays.asList(4, 3, 3);
		});

		game.start();

		List<Car> winners = game.matchResult();
		assertThat(winners).contains(new Car("car1"));
	}

	@Test
	void 지정된_랜덤값에_의한_결과_확인2() { // @checkstyle:ignore
		String carInput = "car1,car2,car3";
		CarEntries entries = new CarEntries(carInput);
		RacingTurn turn = new RacingTurn(4);

		RacingGame game = new RacingGame(entries, turn, size -> {
			return Arrays.asList(1, 5, 4);
		});

		game.start();

		List<Car> winners = game.matchResult();
		assertThat(winners).contains(new Car("car2"), new Car("car3"));
	}

}
