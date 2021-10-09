package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.InvalidPositionValueException;

class PositionTest {
	@Test
	@DisplayName("위치 값을 가지는 Position 생성한다.")
	void create() {
		// given
		int value = 1;

		// when
		Position position = new Position(value);

		// then
		assertThat(position)
			.isEqualTo(new Position(1));
	}

	@Test
	@DisplayName("Position은 최소 0 이상의 값을 가진다.")
	void create_error() {
		// given
		int invalidValue = -1;

		// then
		assertThatThrownBy(() -> new Position(invalidValue))
			.isInstanceOf(InvalidPositionValueException.class)
			.hasMessage("Invalid Position value. The value must be greater than or equal to %d.", 0);
	}

	@Test
	@DisplayName("증가된 Position 값을 반환한다.")
	void move() {
		// given
		Position position = new Position();

		// when
		position = position.move();

		// then
		assertThat(position)
			.isEqualTo(new Position(1));
	}
}