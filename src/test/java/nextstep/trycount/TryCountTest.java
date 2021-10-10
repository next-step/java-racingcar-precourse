package nextstep.trycount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.exception.InvalidTryCountException;

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
}