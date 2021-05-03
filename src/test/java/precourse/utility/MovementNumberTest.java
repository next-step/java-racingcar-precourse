package precourse.utility;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import precourse.race.CarRaceMessage;

class MovementNumberTest {

	@Test
	@DisplayName("임의의 숫자는 0 이상 9 이하만 가능하다.")
	void validFromZeroToNine() {
		assertThatNoException().isThrownBy(() -> new MovementNumber(0));
		assertThatNoException().isThrownBy(() -> new MovementNumber(9));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new MovementNumber(-1))
			.withMessage(CarRaceMessage.INVALID_MOVEMENT_NUMBER);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new MovementNumber(10))
			.withMessage(CarRaceMessage.INVALID_MOVEMENT_NUMBER);
	}

	@Test
	@DisplayName("임의의 숫자가 4 이상이면 전진 가능하다.")
	void canMoveIfMoreThan4() {
		MovementNumber movementNumber1 = new MovementNumber(4);
		MovementNumber movementNumber2 = new MovementNumber(3);

		assertThat(movementNumber1.isMovableNumber()).isTrue();
		assertThat(movementNumber2.isMovableNumber()).isFalse();
	}

}