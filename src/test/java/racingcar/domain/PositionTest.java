package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	void new_FailedByLessThanZero() {
		assertThatThrownBy(() -> {
			new Position(-1);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("위치 초기 값은 0 이상이여야 합니다.");
	}
}