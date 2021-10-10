package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.strategy.RandomMoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
	@DisplayName("자동차 여러대 생성 검증")
	@ParameterizedTest
	@ValueSource(strings = {"car,car2,car3"})
	void createCars(String input) {
		List<String> carNames = Arrays.asList(input.split(","));
		Cars cars = new Cars(carNames, new RandomMoveStrategy());
		assertThat(cars.cars.size()).isEqualTo(carNames.size());
	}
}
