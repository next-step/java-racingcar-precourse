package racinggame.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.InvalidTryCountInputException;

class ParseUtilsTest {

	@DisplayName("콤마를 기준으로, 문자열을 나눈다.")
	@Test
	void parseByComma() {
		// given
		final String input = "abc,def";

		// when then
		assertThat(ParseUtils.parseByComma(input))
			.containsExactly("abc", "def");
	}

	@DisplayName("숫자형태로 된 문자열을 파싱한다.")
	@Test
	void parseInt() {
		// given: none

		// when then
		assertEquals(1, ParseUtils.parseInt("1"));
	}

	@DisplayName("숫자형태로 된 문자열을 파싱한다. 숫자형태가 아니라면 예외를 던진다.")
	@Test
	void parseInt_invalid() {
		// given: none

		// when then
		assertThatThrownBy(() -> ParseUtils.parseInt("문자열"))
			.isInstanceOf(InvalidTryCountInputException.class)
			.hasMessageContaining(InvalidTryCountInputException.INVALID_TRY_COUNT_INPUT);
	}
}