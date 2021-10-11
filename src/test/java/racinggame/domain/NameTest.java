package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

	@DisplayName("자동차 이름 생성")
	@Test
	void create() {
		Name name = Name.of("abcde");
		assertThat(name.getValue()).isEqualTo("abcde");
	}

	@DisplayName("이름이 5자 이하가 아닌 경우 IllegalArgumentException 발생하는지 확인")
	@Test
	void isValidLength() {
		assertThatThrownBy(() -> Name.of("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 이름은 5자 이하로 입력해주세요");
	}
}
