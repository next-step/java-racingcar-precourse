package nextstep.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}