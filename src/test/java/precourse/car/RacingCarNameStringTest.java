package precourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import precourse.race.CarRaceMessage;

class RacingCarNameStringTest {

	@Test
	@DisplayName("자동차 이름은 쉼표(,)로 구분한다.")
	void carNamesSplitByComma() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameString("a,b,c"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarNameString("a|b|c"))
			.withMessage(CarRaceMessage.INVALID_CAR_NUMBER);
	}

	@Test
	@DisplayName("자동차는 2대 이상이어야 한다.")
	void carNumberMustBeMoreThan2() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameString("pobi,crong,honux"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarNameString("pobi"))
			.withMessage(CarRaceMessage.INVALID_CAR_NUMBER);
	}

	@Test
	@DisplayName("자동차 이름은 공백이 될 수 없다.")
	void spaceIsInvalidCarName() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameString(" a, bcd"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarNameString("pobi, "))
			.withMessage(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
	}

	@Test
	@DisplayName("자동차 이름은 1자 이상 5자 이하여야 한다.")
	void carNameMustBeLessThan5() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameString("a,equus"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarNameString("porsche,volkswagen"))
			.withMessage(CarRaceMessage.INVALID_CAR_NAME_LENGTH);
	}

}