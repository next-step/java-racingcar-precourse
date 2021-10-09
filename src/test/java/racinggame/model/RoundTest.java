package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.strategy.RandomMoveStrategy;

@DisplayName("하나의 라운드를 테스트")
class RoundTest {

	@DisplayName("하나의 게임을 생성")
	@Test
	void create() {
		Round round = new Round(Cars.of(new RandomMoveStrategy(), "car-1", "car-2"));

		assertThat(round).isNotNull();
	}

	@DisplayName("라운드를 진행한다")
	@Test
	void winner_round() {
		Round round = new Round(Cars.of(Arrays.asList(
			Car.of(() -> true, "car-1"),
			Car.of(() -> false, "car-2")))
		);
		Round result = round.play();

		final Winners winners = result.findWinners();
		assertThat(winners.getWinners()).containsExactly(new Winner("car-1"));
	}
}