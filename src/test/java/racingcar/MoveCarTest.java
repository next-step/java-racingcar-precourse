package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCarTest {

	@Test
	@DisplayName("랜덤값이 멈춤인지체크한다.")
	void isStop() {
		MoveCar moveCar = new MoveCar(3);
		assertThat(moveCar.status).isEqualTo(MoveStatus.STOP);
	}

	@Test
	@DisplayName("랜덤값이 전진인지체크한다.")
	void isGo() {
		MoveCar moveCar = new MoveCar(4);
		assertThat(moveCar.status).isEqualTo(MoveStatus.GO);
	}
}