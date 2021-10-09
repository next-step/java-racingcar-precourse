package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

	@DisplayName("move 가 호출되면 position 이 전진한다")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 5})
	void move(int startPosition) {
		final Position position = Position.valueOf(startPosition);

		int currentPosition = position.move().currentPosition();

		assertThat(currentPosition).isEqualTo(startPosition + 1);
	}
}