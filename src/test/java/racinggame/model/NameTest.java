package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("이름을 생성한다.")
	public void createName() {
		Name name = new Name("pih");

		assertThat(name).isEqualTo(new Name("pih"));
	}

	@Test
	@DisplayName("자동차 이름이 5글자보다 크면 예외가 발생한다.")
	public void checkLimitLength() {
		assertThrows(IllegalArgumentException.class,
			() -> new Name("racing"));
	}
}