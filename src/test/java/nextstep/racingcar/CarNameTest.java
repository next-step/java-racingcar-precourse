package nextstep.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.exception.InvalidCarNameException;

class CarNameTest {

	@DisplayName("자동차 이름은 0보다 크며, 5보다 작거나 같은 길이의 이름만을 갖는다.")
	@ParameterizedTest(name = "{displayName} / 자동차 이름 : {0}")
	@ValueSource(strings = {"a", "hello"})
	void create(String name) {
		// given: none

		// when then
		assertDoesNotThrow(() -> new CarName(name));
	}

	@DisplayName("자동차 이름은 0보다 크며, 5보다 작거나 같은 길이의 이름만을 갖는다.")
	@ParameterizedTest(name = "{displayName} / 자동차 이름 : {0}")
	@ValueSource(strings = {"", "abcdef"})
	void create_invalid_name(String name) {
		// given:none

		// when then
		assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessageContaining(InvalidCarNameException.INVALID_CAR_NAME);
	}

	@DisplayName("자동차의 이름을 출력한다.")
	@Test
	void print() {
		// given
		final String name = "hello";
		final CarName carName = new CarName(name);

		// when then
		assertEquals(name, carName.toString());
	}

}
