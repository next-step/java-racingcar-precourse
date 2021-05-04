package precourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import precourse.race.CarRaceMessage;

class RacingCarNameSequenceTest {

	@Test
	@DisplayName("자동차 이름은 쉼표(,)로 구분한다.")
	void carNamesSplitByComma() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameSequence("a,b,c"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarNameSequence("a|b|c"))
			.withMessage(CarRaceMessage.INVALID_CAR_NUMBER);
	}

	@Test
	@DisplayName("자동차는 2대 이상이어야 한다.")
	void carNumberMustBeMoreThan2() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameSequence("pobi,crong,honux"));
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new RacingCarNameSequence("pobi"))
			.withMessage(CarRaceMessage.INVALID_CAR_NUMBER);
	}

	@Test
	@DisplayName("자동차 이름은 중복될 수 없다.")
	void validateDuplication() {
		assertThatNoException().isThrownBy(() -> new RacingCarNameSequence("pobi,crong,honux"));
		assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarNameSequence("pobi,honux,pobi"));
		assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarNameSequence("pobi, pobi ,crong"));
	}

}