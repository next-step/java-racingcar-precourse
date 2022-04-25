package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.utils.Error;

public class ValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {"abc", "테스트1", " ", "1 2", "@23#"})
	@DisplayName("입력한 문자가 숫자인지 검증")
	void valid_number(String input) {
		assertThatThrownBy(() -> Validator.validNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Error.COMMON_MESSAGE);
	}
}
