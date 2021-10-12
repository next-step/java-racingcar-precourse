package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import racinggame.exception.BlankNameException;
import racinggame.exception.OverNameLengthException;

class NameTest {
	@Test
	@DisplayName("이름 문자열을 관리하는 래퍼 클래스 생성")
	void create() {
		// given
		String value = "gmoon";

		// when
		Name name = new Name(value);

		// then
		assertThat(name)
			.isEqualTo(new Name(value));
	}

	@Test
	@DisplayName("Name은 이름의 길이는 5자를 초과할 수 없다.")
	void create_error() {
		// given
		String invalidValue = "123456";

		// then
		assertThatThrownBy(() -> new Name(invalidValue))
			.isInstanceOf(OverNameLengthException.class)
			.hasMessage("Name value length exceeded.");
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("Name은 null 이거나 공백인 문자열을 생성할 수 없다.")
	void create_error_when_blank_value(String blankString) {
		// then
		assertThatThrownBy(() -> new Name(blankString))
			.isInstanceOf(BlankNameException.class)
			.hasMessage("Name value is not blank.");
	}
}