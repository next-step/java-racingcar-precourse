package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
	private static final MoveStrategy FORWARD = () -> true;
	private static final MoveStrategy STOP = () -> false;

	@DisplayName("자동차를 생성한다")
	@ParameterizedTest
	@ValueSource(strings = {"gunan", "k"})
	void createTest(String name) {
		assertThat(Car.of(name)).isNotNull();
	}

	@DisplayName("이름이 같으면 같은 자동차이다")
	@ParameterizedTest
	@ValueSource(strings = {"gunan", "k"})
	void equalsTest(String name) {
		assertThat(Car.of(name)).isEqualTo(Car.of(name));
	}

	@DisplayName("이름이 다르면 다른 자동차이다")
	@ParameterizedTest
	@CsvSource(value = {"gunan,lee", "k,a"})
	void notEqualsTest(String name, String differentName) {
		assertThat(Car.of(name)).isNotEqualTo(Car.of(differentName));
	}

	@DisplayName("이동하려다 멈춘 자동차와 이동하지 않은 자동차는 비긴다")
	@Test
	void moveStopTest() {
		Car doStop = Car.of("gunan");
		doStop.move(STOP);
		Car doNothing = Car.of("k");
		assertThat(doNothing.draw(doStop)).isTrue();
		assertThat(doStop.draw(doNothing)).isTrue();
	}

	@DisplayName("전진한 자동차가 이동하지 않은 자동차를 이긴다")
	@Test
	void moveForwardTest() {
		Car doForward = Car.of("gunan");
		doForward.move(FORWARD);
		Car doNothing = Car.of("k");
		assertThat(doForward.win(doNothing)).isTrue();
		assertThat(doNothing.win(doForward)).isFalse();
	}

	@DisplayName("자동차의 이름을 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"gunan", "k"})
	void getNameTest(String name) {
		assertThat(Car.of(name).name()).isEqualTo(name);
	}
}
