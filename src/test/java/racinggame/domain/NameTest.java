package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	@DisplayName("이름의 길이는 5자를 초과할 수 없다.")
	void create_error() {
		// given
		String value = "123456";

		// then
		assertThatThrownBy(() -> new Name(value))
			.isInstanceOf(OverNameLengthException.class)
			.hasMessage("Name value length exceeded.");
	}
}