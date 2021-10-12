package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.UnsatisfiedMinimumValueException;

class RaceCountTest {
	@Test
	@DisplayName("레이스 경주는 최소 0 이상의 값이어야 한다.")
	void create_error() {
		// given
		int invalidCount = -1;

		// then
		assertThatThrownBy(() -> new RaceCount(invalidCount))
			.isInstanceOf(UnsatisfiedMinimumValueException.class)
			.hasMessage("The value must be at least greater than %d.", 0);
	}

	@Test
	@DisplayName("경주 횟수를 감소시킨다.")
	void decrease() {
		// given
		RaceCount raceCount = new RaceCount(2);

		// when
		raceCount = raceCount.decrease();

		// then
		assertThat(raceCount)
			.isEqualTo(new RaceCount(1));
	}

	@Test
	@DisplayName("남아 있는 경주 횟수가 있는지 판단한다.")
	void isRemainingCount() {
		// given
		RaceCount zero = new RaceCount(1);

		// when
		boolean isRemainingCount = zero.isRemainingCount();

		// then
		assertThat(isRemainingCount).isFalse();
	}
}