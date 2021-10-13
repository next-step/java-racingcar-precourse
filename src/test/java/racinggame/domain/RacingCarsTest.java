package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.strategy.DefaultMovingStrategy;

public class RacingCarsTest {
	@DisplayName("자동차들 경주를 하고 리포트를 확인 할 수 있다")
	@ParameterizedTest(name = "{0}가 이동 함을 확인한다")
	@MethodSource("parameters")
	void given_cars_when_race_then_report_result(String name, int position) {
		List<RacingCar> parameters = Arrays.asList(
			new RacingCar("Red"),
			new RacingCar("Blue"));
		RacingCars racingCars = new RacingCars(parameters);

		racingCars.race(new DefaultMovingStrategy());

		List<RacingCarDto> gameResult = racingCars.report();
		assertThat(gameResult.contains(new RacingCarDto(name, position))).isTrue();
	}

	static List<Arguments> parameters() {
		return Arrays.asList(
			Arguments.of("Red", 1),
			Arguments.of("Blue", 1));
	}
}