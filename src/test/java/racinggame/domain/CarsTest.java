package racinggame.domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.strategy.DefaultMovingStrategy;

public class CarsTest {
	@DisplayName("자동차들 경주를 하고 리포트를 확인 할 수 있다")
	@ParameterizedTest(name = "{0}가 이동 함을 확인한다")
	@MethodSource("parameters")
	void given_cars_then_report_result(String name, int position) {
		List<Car> parameters = Arrays.asList(new Car("Red"), new Car("Blue"));

		Cars cars = new Cars(parameters);
		cars.race(new DefaultMovingStrategy());

		List<CarDto> gameResult = cars.report();
		Assertions.assertThat(gameResult.contains(new CarDto(name, position))).isTrue();
	}

	static List<Arguments> parameters() {
		return Arrays.asList(Arguments.of("Red", 1), Arguments.of("Blue", 1));
	}
}
