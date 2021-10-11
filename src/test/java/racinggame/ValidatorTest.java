package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.common.Validator;

public class ValidatorTest {

	@Test
	void 이름_입력_유효성검사() {
		String test = "";
		assertThatThrownBy(() -> Validator.validInputEmpty(test))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_INPUT_NAME);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "^", "0222", "01"})
	void 횟수_입력_유효성검사(String input) {
		assertThatThrownBy(() -> Validator.validTryCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_TRY_COUNT);
	}
}
