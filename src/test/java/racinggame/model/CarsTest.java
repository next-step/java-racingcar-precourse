package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.strategy.RandomMoveStrategy;

@DisplayName("Cars 일급컬렉션 테스트")
class CarsTest {

	@DisplayName("Cars 생성확인")
	@Test
	void create() {
		Cars cars = Cars.of(new RandomMoveStrategy(), "car-1", "car-2");

		assertThat(cars).isNotNull();
		assertThat(cars.numberOfCar()).isEqualTo(2);
	}

	@DisplayName("자동차가 2대미만이면 - 예외 발생")
	@Test
	void empty_name_exception() {
		assertThatThrownBy(() -> Cars.of(new RandomMoveStrategy()))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차는 2대 이상이어야 합니다.");

		assertThatThrownBy(() -> Cars.of(new RandomMoveStrategy(), "car-1"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차는 2대 이상이어야 합니다.");
	}

	@DisplayName("자동차들을 움직인다")
	@Test
	void move() {
		final Cars cars = Cars.of(Arrays.asList(
			Car.of(() -> true, "car1"),
			Car.of(() -> false, "car2"))
		);

		final Cars moveAfterCars = cars.move();

		final List<Car> moveCars = moveAfterCars.getCars();
		final Car moveCar = moveCars.get(0);
		final Car notMoveCar = moveCars.get(1);

		assertThat(moveCar.getName()).isEqualTo("car1");
		assertThat(moveCar.getPosition()).isEqualTo(1);
		assertThat(notMoveCar.getName()).isEqualTo("car2");
		assertThat(notMoveCar.getPosition()).isEqualTo(0);
	}
}