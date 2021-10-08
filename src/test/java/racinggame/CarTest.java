package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("4이상일 경우 전진")
	void 전진_테스트() {
		Car car = new Car("자동차2", 4);
		assertThat(car.move()).isEqualTo(CarStatus.GO);
	}

	@Test
	@DisplayName("3이하일 경우 스탑")
	void 스탑_테스트() {
		Car car = new Car("자동차1", 1);
		assertThat(car.move()).isEqualTo(CarStatus.STOP);
	}
}
