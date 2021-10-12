package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
	private RacingCar car;

	@BeforeEach
	void 테스트_자동차_생성() {
		car = RacingCar.createCar("car");
	}

	@Test
	void 행동번호에_따라_자동차_전진_테스트() {
		car.moveForwardOrStop(7);
		car.moveForwardOrStop(4);
		Assertions.assertThat(car.getDistance()).isEqualTo(2);
	}

	@Test
	void 행동번호에_따라_자동차_정지_테스트() {
		car.moveForwardOrStop(3);
		Assertions.assertThat(car.getDistance()).isEqualTo(0);
	}
}
