package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차를 생성한다.")
	public void createCar() {
		Car car = new Car("pih");

		assertThat(car).isEqualTo(new Car("pih"));
	}

}