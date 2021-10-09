package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 테스트")
class CarTest {

	@DisplayName("자동차는 이름을 입력받아 생성한다")
	@ParameterizedTest
	@ValueSource(strings = {"car-1", "car-2", "car-3"})
	void create(String carName) {
		Car car = Car.valueOf(carName);

		assertThat(car).isNotNull();
		assertThat(car.getName()).isEqualTo(carName);
	}

	@DisplayName("잘못된 이름을 입력해서 생성 - 예외 발생")
	@Test
	void create_invalid_name_exception() {
		final String ERROR_MESSAGE = "자동차의 이름이 잘못되었습니다.";

		assertThatThrownBy(() -> Car.valueOf(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> Car.valueOf(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_MESSAGE);

		assertThatThrownBy(() -> Car.valueOf(" "))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_MESSAGE);
	}

	@DisplayName("긴 이름을 입력해서 생성 - 예외 발생")
	@Test
	void create_name_length_exception() {
		assertThatThrownBy(() -> Car.valueOf("car123"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차는 5글자 이하의 이름이어야 합니다.");
	}

	@DisplayName("입력받은 값이 4이상이면 전진")
	@ParameterizedTest
	@ValueSource(ints = {4, 6, 9})
	void go(int moveNumber) {
		final Car car = Car.valueOf("car-1");
		int beforePosition = car.getPosition();
		car.move(moveNumber);
		int currentPosition = car.getPosition();

		assertThat(currentPosition).isEqualTo(beforePosition + 1);
	}

	@DisplayName("입력받은 값이 3이하이면 정지")
	@ParameterizedTest
	@ValueSource(ints = {0, 3})
	void stop(int moveNumber) {
		final Car car = Car.valueOf("car-1");
		car.move(4);
		car.move(4);
		int beforePosition = car.getPosition();
		car.move(moveNumber);
		int currentPosition = car.getPosition();

		assertThat(currentPosition).isEqualTo(beforePosition);
	}

	@DisplayName("입력받은 값이 0~9가 아니면 - 예외 발생")
	@ParameterizedTest
	@ValueSource(ints = {-1, 10, 100})
	void invalid_move_number_exception(int moveNumber) {
		final Car car = Car.valueOf("car-1");
		assertThatThrownBy(() -> car.move(moveNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("입력 값은 0~9 사이여야 합니다.");

	}
}