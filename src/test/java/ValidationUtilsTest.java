import org.junit.jupiter.api.Test;

import utils.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
	@Test
	void 문자_길이_5_이하_검증() {
		boolean result = ValidationUtils.vaildString("abcde");
		assertThat(result).isTrue();
	}

	@Test
	void 숫자_양수_검증() {
		boolean result = ValidationUtils.vaildNumber("5");
		assertThat(result).isTrue();
	}
}