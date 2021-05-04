package precourse.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceAttemptNumberTest {

	@Test
	@DisplayName("시도 횟수는 1 이상이어야 한다.")
	void attemptNumberMustBeMoreThan1() {
		assertThatNoException().isThrownBy(() -> new CarRaceAttemptNumber("1"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new CarRaceAttemptNumber("0"))
			.withMessage(CarRaceMessage.INVALID_ATTEMPT_NUMBER);
	}

}