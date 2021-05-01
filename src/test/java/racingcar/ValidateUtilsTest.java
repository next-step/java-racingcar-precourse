package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidateUtilsTest {

	@Test
	@DisplayName("입력받은 값이 숫자인지 체크한다.")
	void isNumber() {
		assertThat(ValidateUtils.isNotNumber("3")).isFalse();
	}

	@Test
	@DisplayName("입력받은 차 이름의 길이를 체크한다.")
	void isLessThan6Char() {
		assertThat(ValidateUtils.isLessThan6Char("pobi")).isTrue();
	}
}
