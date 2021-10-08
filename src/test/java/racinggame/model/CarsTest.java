package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@Test
	@DisplayName("자동차들을 생성한다.")
	public void createCars() {
		Cars cars = new Cars(Arrays.asList(new Car("aaa"), new Car("bbb")));

		assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("aaa"), new Car("bbb"))));
	}
}