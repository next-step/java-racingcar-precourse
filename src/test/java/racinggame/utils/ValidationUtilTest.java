package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilTest {

	@Test
	@DisplayName("각 자동차 이름이 5이하인지 검증")
	void validCarNameLength() {
		assertThat(ValidationUtil.validCarNameLength(Arrays.asList("car11", "car22"))).isTrue();
		assertThat(ValidationUtil.validCarNameLength(Arrays.asList("car11", "car222"))).isFalse();
		assertThat(ValidationUtil.validCarNameLength(Arrays.asList("car11", "", "car22"))).isFalse();
	}
}
