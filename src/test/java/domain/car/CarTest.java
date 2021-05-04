package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차는 이름을 받아서 생성할 수 있다")
	void carInit(){
		String carName = "pobi";

		Car car = Car.of(carName);

		assertThat(car).isNotNull();
	}
}
