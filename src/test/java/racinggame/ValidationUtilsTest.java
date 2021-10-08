package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@Test
	@DisplayName("쉼표가 포함되어있는가?")
	void isContainsRest() {
		assertThat(ValidationUtils.validCarNameContainsRest("12345")).isFalse();
		assertThat(ValidationUtils.validCarNameContainsRest("123,45")).isTrue();
	}

	@Test
	@DisplayName("(자동차 이름)5글자 이하인가?")
	void length5() {
		assertThat(ValidationUtils.validCarNameLength("12345")).isTrue();
		assertThat(ValidationUtils.validCarNameLength("123456789")).isFalse();
	}
}
