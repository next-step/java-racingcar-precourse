import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	private static Car classCar = new Car("테스트 자동차");

	@BeforeEach
	static void createCar() {
		do {
			classCar.applyForwardOrNot();
		} while (1 != classCar.getCarMileage());
	}

	@Test
	@DisplayName("자동차 전진 여부 적용")
	void applyForwardOrNot() {
		Car car = new Car("applyForwardOrNot 자동차");
		do {
			car.applyForwardOrNot();
		} while (0 == car.getCarMileage());
		assertThat(car.getCarMileage())
			.isEqualTo(1);
	}

}
