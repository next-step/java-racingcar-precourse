package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.UnsatisfiedMinimumValueException;

class RoundTest {
	@Test
	@DisplayName("라운드 생성시 게임 횟수는 최소 0 이상 이어야한다.")
	void create_error() {
		// given
		int count = -1;

		// then
		assertThatThrownBy(() -> Round.createNew("gmoon,guest", count))
			.isInstanceOf(UnsatisfiedMinimumValueException.class)
			.hasMessage("The value must be at least greater than %d.", 0);
	}

	@Test
	@DisplayName("라운드에 해당되는 자동차들을 경주시킨다.")
	void startRacingCars() {
		// given
		int count = 1;
		Round round = Round.createNew("gmoon,guest", count);

		// when
		round = round.startRacingCars();

		// then
		assertThat(round.isRemainingCount()).isFalse();
	}
}