package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.InvalidCarNameException;

@DisplayName("자동차 이름에 대한 테스트")
class CarNameTest {

	@DisplayName("자동차는 이름을 입력받아 생성한다")
	@ParameterizedTest
	@ValueSource(strings = {"car-1", "car-2", "car-3"})
	void create(String carName) {
		CarName car = CarName.valueOf(carName);

		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(carName);
	}

	@DisplayName("잘못된 이름을 입력해서 생성 - 예외 발생")
	@Test
	void create_invalid_name_exception() {
		final String ERROR_MESSAGE = "자동차의 이름이 잘못되었습니다.";

		assertThatThrownBy(() -> CarName.valueOf(null))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> CarName.valueOf(""))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> CarName.valueOf(" "))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessage(ERROR_MESSAGE);
	}

	@DisplayName("긴 이름을 입력해서 생성 - 예외 발생")
	@Test
	void create_name_length_exception() {
		assertThatThrownBy(() -> CarName.valueOf("car123"))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessage("자동차는 5글자 이하의 이름이어야 합니다.");
	}
}