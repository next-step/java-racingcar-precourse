package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	@DisplayName("Car클래스의 forward함수의 테스트")
	public void forwardTest() {
		// given, when #1
		Car pobiCar = new Car("pobi", 0);

		// then #1
		assertThat(pobiCar.getPosition()).isEqualTo(0);

		// when #2
		pobiCar.forward();

		// then #2
		assertThat(pobiCar.getPosition()).isEqualTo(1);

	}
}
