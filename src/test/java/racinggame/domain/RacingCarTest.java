package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.strategy.DefaultMovingStrategy;
import racinggame.strategy.MovingStrategy;
import racinggame.strategy.NoMovingStrategy;

public class RacingCarTest {
	@DisplayName("자동차를 움직임을 결정할 수 있다")
	@ParameterizedTest(name = "{2}")
	@MethodSource("parameters")
	void given_strategy_then_decide_move_or_not(MovingStrategy strategy, int expectedPosition, String message) {
		RacingCar racingCar = new RacingCar("Jay");
		int position = racingCar.move(strategy);

		assertThat(position).isEqualTo(expectedPosition);
	}

	static List<Arguments> parameters() {
		return Arrays.asList(
			Arguments.of(new NoMovingStrategy(), 0, "자동차가 멈춘다"),
			Arguments.of(new DefaultMovingStrategy(), 1, "자동차가 전진한다"));
	}
}