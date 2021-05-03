import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Car.Car;

public class CarTest {

	@Test
	@DisplayName("자동차 이름 유효성 어긋나는지 검사")
	void validationCarNameLength() {
		assertThatThrownBy(() -> {
			Car car = new Car("pobi555");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 " + Car.NAME_LENGTH_MAX + "자 이하만 가능하다.");
	}

	@Test
	@DisplayName("자동차객체에 이름이 올바르게 저장 되었는지 검사")
	void validataionCarName() {
		Car car = new Car("pobi");
		assertThat(car.getName()).isEqualTo("pobi");
	}
}
