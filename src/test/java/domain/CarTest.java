package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 생성() {
		String carName = "hanna";
		Car car = new Car(carName);
		assertThat(car.getName()).isEqualTo(carName);
		assertThat(car.getDistance()).isEqualTo(0);
	}

	@Test
	void 이름_5자_초과인_경우_예외처리() {
		String carName = "hannah";
		assertThatThrownBy(() -> {
			new Car(carName);
		}).isInstanceOf(Exception.class)
				.hasMessageContaining(ERROR_MESSAGE);
	}

}
