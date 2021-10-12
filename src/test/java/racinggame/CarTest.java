package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("자동차 생성")
	void createCar() {
		assertThat(new Car("pobi").getName()).isEqualTo("pobi");
		assertThat(new Car("crong").getName()).isEqualTo("crong");
	}

	@Test
	@DisplayName("자동차 생성 5자초과 에러 발생")
	void createCarWithLengthException() {
		assertThatThrownBy(() -> new Car("123456")).hasMessageContaining("[ERROR] 이름")
														 .isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("랜덤값이 4이상이면 전진")
	void moveForward() {
		Car car = new Car("pobi");
		car.moveOrStop(4);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤값이 3이하면 멈춤")
	void stop() {
		Car car = new Car("pobi");
		car.moveOrStop(3);
		assertThat(car.getPosition()).isZero();
	}
}
