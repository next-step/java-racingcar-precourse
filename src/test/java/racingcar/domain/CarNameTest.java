package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
	@DisplayName("자동차의 이름을 생성한다")
	@ParameterizedTest
	@ValueSource(strings = {"gunan", "k"})
	void createTest(String name) {
		assertThat(new CarName(name)).isNotNull();
	}

	@DisplayName("자동차의 이름은 1자 이상 5자 이하여야 한다")
	@ParameterizedTest
	@ValueSource(strings = {"", "gunani"})
	void invalidNameTest(String name) {
		assertThatThrownBy(() -> new CarName(name))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이름의 값이 같으면 같은 이름이다")
	@ParameterizedTest
	@ValueSource(strings = {"gunan"})
	void equalsTest(String name) {
		assertThat(new CarName(name)).isEqualTo(new CarName(name));
	}
}
