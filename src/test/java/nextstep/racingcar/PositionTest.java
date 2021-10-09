package nextstep.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

	@DisplayName("4 이상의 값을 입력받은 경우, 자동차의 위치를 증가시킨다.")
	@ParameterizedTest(name = "{displayName} / 입력값 : {0} / 위치 : 0 -> {1}")
	@CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
	void move(int input, int expected) {
		// given
		final Position position = new Position();

		// when then
		assertEquals(new Position(expected), position.move(input));
	}
}