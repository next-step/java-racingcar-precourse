package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.result.CarMoveResults;

class CarsTest {

	@Test
	@DisplayName("자동차들을 받아 생성한다")
	void create(){
		List<Car> carArrays = Arrays.asList(Car.of("pobi"), Car.of("test"));

		Cars cars = Cars.of(carArrays);

		assertThat(cars).isNotNull();
	}

	@Test
	@DisplayName("자동차들의 move를 전부 호출 후 결과를 리턴")
	void move(){
		int expectedSize = 2;
		List<Car> carArrays = Arrays.asList(Car.of("pobi"), Car.of("test"));
		Cars cars = Cars.of(carArrays);

		CarMoveResults results = cars.move();

		assertThat(results).isNotNull();
		assertThat(results.getCarMoveResults().size()).isEqualTo(expectedSize);
	}
}
