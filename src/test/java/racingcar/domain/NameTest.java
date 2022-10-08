package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

	@ParameterizedTest(name = "자동차 이름이 빈값이거나 5자 초과시 오류가 발생한다. 이름: {argumentsWithNames}")
	@ValueSource(strings = {"", " ", "123456"})
	void new_FailedByOverNameMaxLength(String name) {
		assertThatThrownBy(() -> {
			new Name(name);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 빈값이 아니며 5자 이하여야 합니다.");
	}
}