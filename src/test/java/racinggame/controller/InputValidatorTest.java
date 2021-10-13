package racinggame.controller;

import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

	@Test
	@DisplayName("true, false로 반환한다")
	void 통합확인(){
		String tc_1 = "car1,car2,car3,car4";
		String tc_2 = "car1,car3,,,";

		Assertions.assertEquals(true, InputValidator.validatePipeline(tc_1));
		Assertions.assertEquals(false, InputValidator.validatePipeline(tc_2));
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 빈문자열확인() {
		String input = "";

		assertThatThrownBy(() -> InputValidator.isEmptyInput(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 자동차이름빈문자열확인() {
		String input = "car1,car2,car3,,car4";

		assertThatThrownBy(() -> InputValidator.isEmptyCarName(input.split(",")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 중복이릅확인() {
		String input = "car1,car1,car3,car4";

		assertThatThrownBy(() -> InputValidator.isNonDuplicate(input.split(",")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	@DisplayName("IllegalArgumentException 발생시킨다")
	void 참가자글자수확인() {
		String input = "car1,car2221,car3,car4";

		assertThatThrownBy(() -> InputValidator.isRightNameLength(input.split(",")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}
