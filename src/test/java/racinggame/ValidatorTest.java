package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.common.Validator;

public class ValidatorTest {

	@ParameterizedTest(name = "자동차 이름 입력 유효성 검사 {0}")
	@ValueSource(strings = {"  ", ",하하", "정주나요안정주나요,박명수", "^***,박"})
	void 이름_입력_유효성검사(String input) {
		assertThatThrownBy(() -> Validator.validCarNamesPattern(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_INPUT_CAR_NAMES);
	}

	@Test
	void 이름_중복_검사() {
		String input = "LEE,LEE,LEEE";
		assertThatThrownBy(() -> Validator.validCarNamesDuplicate(input))
			.isInstanceOf(IllegalStateException.class)
			.hasMessage(ERROR_DUP_CAR_NAMES);
	}

}
