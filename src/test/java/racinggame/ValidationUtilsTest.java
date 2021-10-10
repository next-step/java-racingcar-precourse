package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
	@Test
	@DisplayName("같은 이름이 있는지 검증")
	void invalidName() {
		assertThat(ValidationUtils.validName("car,car")).isFalse();
		assertThat(ValidationUtils.validName("car,car2")).isTrue();
	}

	@Test
	@DisplayName("이름이 5글자 이하인지 검증")
	void invalidNameLength() {
		assertThat(ValidationUtils.validNameLength("car")).isTrue();
		assertThat(ValidationUtils.validNameLength("car12345")).isFalse();
	}

	@Test
	@DisplayName("이름이 2개 이상인지 검증")
	void invalidTwoMore() {
		assertThat(ValidationUtils.validTwoMore("car")).isFalse();
		assertThat(ValidationUtils.validTwoMore("car, car2")).isTrue();
	}

	@Test
	@DisplayName("이동 횟수가 숫자인지 검증")
	void invalidNumber() {
		assertThat(ValidationUtils.validNumber("1")).isTrue();
		assertThat(ValidationUtils.validNumber("a")).isFalse();
	}

	@Test
	@DisplayName("이동 횟수가 0보다 큰 숫자인지")
	void invalidZeroMore() {
		assertThat(ValidationUtils.validZeroMore("12")).isTrue();
		assertThat(ValidationUtils.validZeroMore("0")).isFalse();

	}
}
