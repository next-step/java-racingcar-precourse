package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	@DisplayName("위치 초기값이 0 미만인 경우 오류가 발생한다.")
	void new_FailedByLessThanZero() {
		assertThatThrownBy(() -> {
			new Position(-1);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("위치 초기 값은 0 이상이여야 합니다.");
	}

	@Test
	@DisplayName("위치값(숫자) → 1당 '-'로 변환하여 반환한다.")
	void getPositionToBar() {
		Position position = new Position(3);
		assertThat(position.getPositionToBar()).isEqualTo("---");
	}
}