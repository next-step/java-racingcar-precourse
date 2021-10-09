package nextstep.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.exception.InvalidCarNameException;
import nextstep.exception.InvalidPositionException;

public class RacingCarTest {

	@DisplayName("자동차를 생성한다.")
	@Test
	void create() {
		// given:none

		// when then
		assertDoesNotThrow(() -> new RacingCar("hello", 0));
	}

	@DisplayName("자동차를 생성한다. (자동차 이름이 오류인 경우)")
	@ParameterizedTest(name = "{displayName} / 자동차 이름 : {0}")
	@ValueSource(strings = {"", "abcdef"})
	void create_invalid_name(String name) {
		// given: none

		// when then
		assertThatThrownBy(() -> new RacingCar(name))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessageContaining(InvalidCarNameException.INVALID_CAR_NAME);
	}

	@DisplayName("자동차를 생성한다. (자동차 위치가 오류인 경우)")
	@Test
	void create_invalid_position() {
		// given: none

		// when then
		assertThatThrownBy(() -> new RacingCar("hello", -1))
			.isInstanceOf(InvalidPositionException.class)
			.hasMessageContaining(InvalidPositionException.INVALID_POSITION);
	}

}
