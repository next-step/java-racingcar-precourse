package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@Test
	@DisplayName("자동차들을 받아 생성한다")
	void create(){
		List<Car> carArrays = Arrays.asList(Car.of("pobi"), Car.of("test"));

		Cars cars = Cars.of(carArrays);

		assertThat(cars).isNotNull();
	}
}
