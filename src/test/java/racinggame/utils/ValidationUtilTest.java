package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilTest {

	@Test
	@DisplayName("각 자동차 이름이 5이하인지 검증")
	void validCarNameLength() {
		assertThat(ValidationUtil.validCarNameLength(new String[]{"car11", "car22"})).isTrue();
		assertThat(ValidationUtil.validCarNameLength(new String[]{"car11", "car222"})).isFalse();
		assertThat(ValidationUtil.validCarNameLength(new String[]{"car11", "", "car22"})).isFalse();
	}

	@Test
	void 시도할_회수가_숫자만_입력됐는지_검증(){
		assertThat(ValidationUtil.validOnlyNumber("1")).isTrue();
		assertThat(ValidationUtil.validOnlyNumber("1둘")).isFalse();
		assertThat(ValidationUtil.validOnlyNumber("")).isFalse();
	}
}
