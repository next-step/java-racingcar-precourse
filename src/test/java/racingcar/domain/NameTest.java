package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.utils.Error;

public class NameTest {
	@ParameterizedTest()
	@ValueSource(strings = { "", "공백 금지", "5글자초과명", " "})
	@DisplayName("이름 검증")
	void valid_car_name(String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Error.COMMON_MESSAGE);
	}
}
