package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 테스트")
class CarTest {

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