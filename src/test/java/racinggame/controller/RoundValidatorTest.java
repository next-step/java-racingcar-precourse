package racinggame.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundValidatorTest {
	@Test
	@DisplayName("true, false로 반환한다")
	void 통합확인(){
		String tc_1 = "39";
		String tc_2 = "0";

		Assertions.assertEquals(true, RoundValidator.checkPipeline(tc_1));
		Assertions.assertEquals(false, RoundValidator.checkPipeline(tc_2));
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 빈문자확인() {
		String input = "";

		assertThatThrownBy(() -> RoundValidator.isNotEmpty(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 숫자인지확인() {
		String input = "테스트";

		assertThatThrownBy(() -> RoundValidator.isNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 일보다큰지확인() {
		String tc_1 = "0";

		assertThatThrownBy(() -> RoundValidator.isOverOne(tc_1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");

	}
}
