package precourse.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceTryNumberTest {

	@Test
	@DisplayName("시도 횟수는 1 이상이어야 한다.")
	void tryNumberMustBeMoreThan1() {
		assertThatNoException().isThrownBy(() -> new CarRaceTryNumber("1"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new CarRaceTryNumber("0"))
			.withMessage(CarRaceMessage.INVALID_TRY_NUMBER);
	}

}