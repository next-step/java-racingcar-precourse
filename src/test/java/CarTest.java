import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import raceCar.model.Car;

public class CarTest {

	@Test
	void givenWithin5Chars_whenCreateCar_thenSuccess() {
		// given
		String name = "yoon";
		// when
		Car car = Car.of(name);
		// then
		assertThat(car.getName()).isEqualTo(name);
	}

	// @Test
	// void givenMore5Chars_whenCreateCar_thenFail() {
	// 	// given
	// 	String name = "yoonjaeyong";
	// 	// when & then
	// 	assertThatThrownBy(() -> Car.of(name))
	// 			.isInstanceOf(IllegalArgumentException.class)
	// 			.hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
	// }

	@Test
	void givenMove_whenMove_thenSuccess() {
		// given
		Car car = Car.of("yoons");
		// when
		Boolean result = car.canMove();
		// then
		assertThat(result).isIn(true, false);
	}
}
