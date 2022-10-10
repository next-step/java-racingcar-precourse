package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("차 이름 6자리 테스트")
	void carNameFail() {
		assertThrows(IllegalArgumentException.class, () -> new Car("junkon"));
	}

	@Test
	@DisplayName("차 전진 테스트")
	void run() {
		// given
		Car car = new Car("jun");

		// when
		car.run(4);

		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("차 전진 실패 테스트")
	void runFail() {
		// given
		Car car = new Car("jun");

		// when
		car.run(1);

		// then
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("게임 상태 출력 테스트")
	void gameStatus() {
		// given
		Car car = new Car("jun");

		// when
		car.run(5);
		car.run(7);

		// then
		assertThat(car.gameStatus()).isEqualTo("jun : --");
	}

}
