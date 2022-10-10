package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
	@DisplayName("자동차 이름 생성")
	@ParameterizedTest
	@ValueSource(strings = {"abcde", "12345"})
	void carName(String carName) {
		CarName actual = CarName.from(carName);
		assertThat(actual).isNotNull();
		assertThat(actual.getValue()).isEqualTo(carName);
	}

	@DisplayName("자동차 이름 5자 초과")
	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "asdhjsad", "     123434267657     "})
	void carName_over_5letters(String carName) {
		assertThatThrownBy(() -> CarName.from(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름은 5자 이하만 가능합니다.");
	}

	@DisplayName("자동차 이름 공백")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "     "})
	void carName_empty(String carName) {
		assertThatThrownBy(() -> CarName.from(carName))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 공백일 수는 없습니다.");
	}

	@DisplayName("자동차 이름 좌우 공백 무시")
	@ParameterizedTest
	@ValueSource(strings = {"  abcde  ", " 12345 "})
	void carName_trim(String carName) {
		CarName actual = CarName.from(carName);
		assertThat(actual).isNotNull();
		assertThat(actual.getValue()).isEqualTo(carName.trim());
	}
}