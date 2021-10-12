package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {
	@Test
	void 자동차_이름_다섯_글자_이하() {
		assertThat(CarName.isOverThanFiveLetters("yhkim")).isFalse();
	}

	@Test
	void 자동차_이름_다섯_글자_초과() {
		assertThat(CarName.isOverThanFiveLetters("yh_kim")).isTrue();
	}
}
