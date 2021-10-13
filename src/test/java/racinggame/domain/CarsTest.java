package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {

	@ParameterizedTest
	@CsvSource(value = {"pobi,son,pro:3", "abc,def:2"}, delimiter = ':')
	void 자동차는_n대_존재(String carNames, int carCount){
		Cars cars = new Cars(carNames);

		assertThat(cars.getCars().size()).isEqualTo(carCount);
	}
}
