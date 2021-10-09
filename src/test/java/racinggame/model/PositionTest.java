package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

	@DisplayName("입력받은 값이 4이상이면 전진")
	@ParameterizedTest
	@ValueSource(ints = {4, 6, 9})
	void go(int moveNumber) {
		final Position position = Position.valueOf(0);
		int beforePosition = position.currentPosition();
		final Position afterPosition = position.move(moveNumber);
		int currentPosition = afterPosition.currentPosition();

		assertThat(currentPosition).isEqualTo(beforePosition + 1);
	}

	@DisplayName("입력받은 값이 3이하이면 정지")
	@ParameterizedTest
	@ValueSource(ints = {0, 3})
	void stop(int moveNumber) {
		final Position position = Position.valueOf(2);
		int beforePosition = position.currentPosition();
		final Position afterPosition = position.move(moveNumber);
		int currentPosition = afterPosition.currentPosition();

		assertThat(currentPosition).isEqualTo(beforePosition);
	}

	@DisplayName("입력받은 값이 0~9가 아니면 - 예외 발생")
	@ParameterizedTest
	@ValueSource(ints = {-1, 10, 100})
	void invalid_move_number_exception(int moveNumber) {
		final Position position = Position.valueOf(0);
		assertThatThrownBy(() -> position.move(moveNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력 값은 0~9 사이여야 합니다.");

	}
}