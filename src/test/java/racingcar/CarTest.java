package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sun.security.validator.ValidatorException;

public class CarTest {
	private Car car;

	@BeforeEach
	void setUp() throws ValidatorException {
		car = new Car("pobi");
	}

	@Test
	@DisplayName("차에 랜덤값을 전달하여 이동 여부 테스트")
	void isMoveTest() {
		assertThat(car.isMovable(3)).isFalse();
		assertThat(car.isMovable(4)).isTrue();
	}

	@Test
	@DisplayName("차에 랜덤값을 전달하여 이동 거리 테스트")
	void moveCarTest() {
		assertThat(car.move(3)).isEqualTo(0);
		assertThat(car.move(4)).isEqualTo(1);
		assertThat(car.move(1)).isEqualTo(1);
		assertThat(car.move(9)).isEqualTo(2);
	}

	@Test
	@DisplayName("현재 차의 정보를 출력")
	void printCarInfo() {
		assertThat(car.toString()).isEqualTo("pobi : ");
		moveCarTest();
		assertThat(car.toString()).isEqualTo("pobi : --");
	}
}
