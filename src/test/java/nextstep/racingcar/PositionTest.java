package nextstep.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.exception.InvalidPositionException;

class PositionTest {

	@DisplayName("자동차의 위치를 증가시킨다.")
	@Test
	void move() {
		// given
		final Position position = new Position();

		// when then
		assertEquals(new Position(1), position.move());
	}

	@DisplayName("현재 자동차의 위치를 Dash 를 이용하여 표현한다.")
	@ParameterizedTest(name = "{displayName} / 자동차 position : {0} / 위치 : {1}")
	@CsvSource(value = {"0:''", "3:---"}, delimiter = ':')
	void toString(int pos, String expected) {
		// given
		final Position position = new Position(pos);

		// when then
		assertEquals(expected, position.toString());
	}

	@DisplayName("자동차의 위치는 0보다 큰 위치만을 갖는다.")
	@Test
	void create() {
		// given:none

		// when then
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(InvalidPositionException.class)
			.hasMessageContaining(InvalidPositionException.INVALID_POSITION);
	}

}