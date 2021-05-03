package precourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import precourse.utility.MovementNumber;

public class RacingCarTest {

	private RacingCar racingCar;

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar(new RacingCarName("pobi"));
	}

	@Test
	@DisplayName("임의의 숫자가 4 이상이면 전진한다.")
	void movable() {
		racingCar.decideMovement(new MovementNumber(4));
		assertThat(racingCar.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("임의의 숫자가 4 미만이면 정지한다.")
	void notMovable() {
		racingCar.decideMovement(new MovementNumber(3));
		assertThat(racingCar.getPosition()).isEqualTo(0);
	}

}
