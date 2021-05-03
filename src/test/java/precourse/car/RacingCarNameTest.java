package precourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import precourse.race.CarRaceMessage;

public class RacingCarNameTest {

	@Test
	@DisplayName("자동차 이름은 1자 이상 5자 이하여야 한다.")
	void carNameLengthBetweenOneAndFive() {
		assertThatNoException().isThrownBy(() -> new RacingCarName("a"));
		assertThatNoException().isThrownBy(() -> new RacingCarName("honux"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarName("mercedes"))
			.withMessage(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarName(" "))
			.withMessage(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
	}

}
