package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차를 생성한다.")
	public void createCar() {
		Car car = new Car("pih");

		assertThat(car).isEqualTo(new Car("pih"));
	}

	@Test
	@DisplayName("자동차의 레이싱 정보를 알 수 있다.")
	public void racing() {
		Car car = new Car("pih");

		assertAll(
			() -> {
				Car result = car.racing(4);
				assertThat(result).isEqualTo(new Car("pih", 1));
				Car result2 = result.racing(3);
				assertThat(result2).isEqualTo(new Car("pih", 1));
			}
		);
	}

}