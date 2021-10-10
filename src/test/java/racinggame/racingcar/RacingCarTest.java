package racinggame.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.InvalidCarNameException;
import racinggame.exception.InvalidPositionException;
import racinggame.generator.SpecificNumberGenerator;
import racinggame.move.RandomMovingStrategy;
import racinggame.move.SpecificMovingStrategy;

public class RacingCarTest {

	@DisplayName("자동차를 생성한다.")
	@Test
	void create() {
		// given:none

		// when then
		assertDoesNotThrow(() -> new RacingCar("hello", 0, RandomMovingStrategy.getInstance()));
	}

	@DisplayName("자동차를 생성한다. (자동차 이름이 오류인 경우)")
	@ParameterizedTest(name = "{displayName} / 자동차 이름 : {0}")
	@ValueSource(strings = {"", "abcdef"})
	void create_invalid_name(String name) {
		// given: none

		// when then
		assertThatThrownBy(() -> new RacingCar(name, RandomMovingStrategy.getInstance()))
			.isInstanceOf(InvalidCarNameException.class)
			.hasMessageContaining(InvalidCarNameException.INVALID_CAR_NAME);
	}

	@DisplayName("자동차를 생성한다. (자동차 위치가 오류인 경우)")
	@Test
	void create_invalid_position() {
		// given: none

		// when then
		assertThatThrownBy(() -> new RacingCar("hello", -1, RandomMovingStrategy.getInstance()))
			.isInstanceOf(InvalidPositionException.class)
			.hasMessageContaining(InvalidPositionException.INVALID_POSITION);
	}

	@DisplayName("자동차의 위치를 변경한다.")
	@ParameterizedTest(name = "{displayName} / 입력값 : {0} / 위치 : 0 -> {1}")
	@CsvSource(value = {"3:0", "4:1"}, delimiter = ':')
	void move(int input, int expected) {
		// given
		final String carName = "hello";
		final SpecificMovingStrategy movingStrategy = new SpecificMovingStrategy(new SpecificNumberGenerator(input));

		final RacingCar racingCar = new RacingCar(carName, movingStrategy);

		// when then
		assertEquals(new RacingCar(carName, expected, movingStrategy), racingCar.move());
	}

	@DisplayName("자동차의 이름과 위치를 출력한다.")
	@Test
	void toString_test() {
		// given
		final RacingCar racingCar = new RacingCar("hello", 5, RandomMovingStrategy.getInstance());

		// when then
		assertEquals("hello : -----", racingCar.toString());
	}

	@DisplayName("임의의 위치와 자동차의 위치를 비교하여, 더 큰 위치를 반환한다.")
	@Test
	void getGreaterPosition() {
		// given
		final RacingCar racingCar = new RacingCar("hello", 15, RandomMovingStrategy.getInstance());

		// when then
		assertEquals(new Position(15), racingCar.getGreaterPosition(new Position(10)));
	}
}
