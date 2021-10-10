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
}
