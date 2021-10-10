package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@DisplayName("자동차 생성")
	@Test
	void create() {
		CarName carName = CarName.of("abcde");
		Car car = Car.of(carName);
		assertThat(car.getCarName().getName()).isEqualTo("abcde");
	}
}
