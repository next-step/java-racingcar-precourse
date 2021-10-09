package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 일급컬렉션 테스트")
class CarsTest {

	@DisplayName("Cars 생성확인")
	@Test
	void create() {
		Cars cars = Cars.of("car-1", "car-2");

		assertThat(cars).isNotNull();
		assertThat(cars.numberOfCar()).isEqualTo(2);
	}

	@DisplayName("자동차가 2대미만이면 - 예외 발생")
	@Test
	void empty_name_exception() {
		assertThatThrownBy(Cars::of)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차는 2대 이상이어야 합니다.");

		assertThatThrownBy(() -> Cars.of("car-1"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차는 2대 이상이어야 합니다.");
	}

}