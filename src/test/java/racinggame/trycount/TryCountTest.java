package racinggame.trycount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.InvalidTryCountException;

class TryCountTest {

	@DisplayName("시도횟수는 0보다 크거나 같은 값만 갖는다.")
	@Test
	void create() {
		// given: none

		// when then
		assertThatThrownBy(() -> new TryCount(-1))
			.isInstanceOf(InvalidTryCountException.class)
			.hasMessageContaining(InvalidTryCountException.INVALID_TRY_COUNT);
	}

	@DisplayName("시도횟수를 감소시킨다.")
	@Test
	void decrease() {
		// given
		final int tryCount = 2;

		// when then
		assertEquals(new TryCount(tryCount - 1), new TryCount(tryCount).decrease());
	}

	@DisplayName("시도횟수를 0 미만으로 감소시킬 수 없다.")
	@Test
	void decrease_invalid() {
		// given
		final TryCount tryCount = new TryCount(0);

		// when then
		assertThatThrownBy(tryCount::decrease)
			.isInstanceOf(InvalidTryCountException.class)
			.hasMessageContaining(InvalidTryCountException.INVALID_TRY_COUNT);
	}
}