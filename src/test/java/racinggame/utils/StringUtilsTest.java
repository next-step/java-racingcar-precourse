package racinggame.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringUtilsTest {
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("빈 문자열인지 판단")
	void isBlank(String blankString) {
		// given

		// when
		boolean isBlank = StringUtils.isBlank(blankString);

		// then
		assertThat(isBlank).isTrue();
	}
}