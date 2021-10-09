package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
class CarTest {

	@DisplayName("이름을 입력받아 자동차를 생성")
	@Test
	void create_car() {
		final String name = "car-1";
		final Car car = Car.of(name);

		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(name);
	}

	@DisplayName("자동차를 전진하여 포지션이 변경되는 것을 확인한다")
	@Test
	void move_car() {
		final Car car = Car.of(() -> true, "car-1");
		final int beforePosition = car.getPosition();
		car.move();
		final int afterPosition = car.getPosition();
		assertThat(afterPosition).isEqualTo(beforePosition + 1);
	}

	@DisplayName("자동차가 전진하지 않으면 포지션이 같아야 한다")
	@Test
	void not_move_car() {
		final Car car = Car.of(() -> false, "car-1");
		final int beforePosition = car.getPosition();
		car.move();
		final int afterPosition = car.getPosition();
		assertThat(afterPosition).isEqualTo(beforePosition);
	}
}