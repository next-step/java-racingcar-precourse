package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.result.CarMoveResults;
import domain.car.strategy.ConditionMovableStrategy;

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

	@Test
	@DisplayName("자동차들의 move를 전부 호출 후 가장 높은 포지션 리턴")
	void maxPosition(){
		Position expectedMaxPosition = new Position(5);
		Cars cars = Cars.of(
			Arrays.asList(
				makeCar("1번", 2),
				makeCar("2번", 5),
				makeCar("3번", 4),
				makeCar("4번", 5)
			)
		);

		CarMoveResults results = cars.move();

		assertThat(results.getMaxPosition()).isEqualTo(expectedMaxPosition);
	}

	private Car makeCar(String carName, int position) {
		return Car.of(carName, new Position(position), new ConditionMovableStrategy(false));
	}
}
