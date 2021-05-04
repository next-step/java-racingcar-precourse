package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sun.security.validator.ValidatorException;

public class ValidationTest {
	private static void nullName() throws ValidatorException {
		new Car("");
	}

	private static void overName() throws ValidatorException {
		new Car("가나다라마바");
	}

	@Test
	@DisplayName("자동차 이름 길이 제한 테스트")
	public void validateCarName() throws ValidatorException {
		assertThrows(ValidatorException.class, ValidationTest::overName);
		assertThrows(ValidatorException.class, ValidationTest::nullName);

		Car car = new Car("가나다라마");
		assertThat(RacingRule.isInvalidCarName(car.getName())).isFalse();
	}
}
