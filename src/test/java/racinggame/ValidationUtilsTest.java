package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racinggame.util.ValidationUtils;

public class ValidationUtilsTest {
	@Test
	void 자동차_이름길이_5자_이하인지_검증() {
		assertThat(ValidationUtils.validCarName("a")).isTrue();
		assertThat(ValidationUtils.validCarName("abdef")).isTrue();
		assertThat(ValidationUtils.validCarName("abdefg")).isFalse();
		assertThat(ValidationUtils.validCarName(null)).isFalse();
		assertThat(ValidationUtils.validCarName("")).isFalse();
	}
	
	
}
