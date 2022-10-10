package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

	@ParameterizedTest
	@ValueSource(strings = {"hahoho", "hahoho1", "hahoho11", "hahoho123"})
	@DisplayName("자동차 이름이 5자를 넘어가면 예외를 발생시킨다.")
	void carNameLengthException(String name) {
		assertThatThrownBy(() -> new RacingCar(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("자동차 이름이 공백이거나 null 이면 예외를 발생시킨다.")
	void carNameEmptyException(String name) {
		assertThatThrownBy(() -> new RacingCar(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"haha", "hihi", "hoho"})
	@DisplayName("자동차 이름이 5자 이하면 예외를 발생시키지 않는다.")
	void racingCarNameLengthTest(String name) {
		assertThatCode(() -> new RacingCar(name)).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@ValueSource(strings = {"haha", "hihi", "hoho"})
	@DisplayName("초기 생성된 자동차의 위치는 0 이다.")
	void racingCarPositionTest(String name) {
		RacingCar car = new RacingCar(name);
		assertThat(car.getPositionValue()).isZero();
	}

	@ParameterizedTest
	@ValueSource(strings = {"haha", "hihi", "hoho"})
	@DisplayName("자동차의 이름을 반환한다.")
	void racingCarNameTest(String name) {
		RacingCar car = new RacingCar(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	@DisplayName("이동 전략이 true 일 경우 자동차의 위치가 1 증가한다.")
	void racingCarMoveTest() {
		RacingCar car = new RacingCar("haha");
		car.move(() -> true);
		assertThat(car.getPositionValue()).isEqualTo(1);
	}

	@Test
	@DisplayName("이동 전략이 false 일 경우 자동차의 위치가 증가하지 않는다.")
	void racingCarNotMoveTest() {
		RacingCar car = new RacingCar("haha");
		car.move(() -> false);
		assertThat(car.getPositionValue()).isZero();
	}
}