package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.strategy.FixedMovableStrategy;

public class CarsTest {

	@ParameterizedTest
	@CsvSource(value = {"pobi,son,pro:3", "abc,def:2"}, delimiter = ':')
	void 자동차는_n대_존재(String carNames, int carCount){
		Cars cars = new Cars(parse(carNames));

		assertThat(cars.getCars().size()).isEqualTo(carCount);
	}

	@Test
	void n대의_자동차_전체를_움직인다() {
		Cars cars = new Cars(Arrays.asList("pobi","son","pro"), new FixedMovableStrategy(4));

		cars.move();

		for (Car car : cars.getCars()) {
			assertThat(car.getDrivenDistance()).isEqualTo(1);
		}

	}

	private List<String> parse(final String carNames) {
		return new ArrayList<>(Arrays.asList(carNames.split(",")));
	}
}

