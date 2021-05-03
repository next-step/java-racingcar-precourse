package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidationTest {

	@ParameterizedTest
	@ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
	public void 자동차_이름은_5자_이하만_가능(String carNames) {
		//given
		Car car = new Car(carNames);

		//when
		String carName = car.getCarName();

		//then
		assertThat(carName).hasSizeLessThanOrEqualTo(5);
	}

	@ParameterizedTest
	@ValueSource(strings = {"aaaaaa", "aaaaaaa", "aaaaaaa"})
	public void 자동차_이름이_6자_이상일_경우엔_에러_발생(String carNames) {
		//given
		//when
		//then
		assertThrows(IllegalArgumentException.class, () -> new Car(carNames));
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
	public void 자동차_이동_조건은_0에서_9_사이의_값(int condition) {
		//given
		Car car = new Car("car");

		//when
		int distance = car.move(condition);

		//then
		assertThat(distance).isExactlyInstanceOf(Integer.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -2, -3, 10, 11, 12})
	public void 자동차_이동_조건이_0에서_9_사이_값이_아니면_에러_발생(int condition) {
		//given
		Car car = new Car("car");

		//when
		assertThrows(IllegalArgumentException.class, () -> car.move(condition));
	}

	@Test
	public void 자동차_이름은_공백_불가() {
		//given
		//when
		//then
		assertThrows(IllegalArgumentException.class, () -> new Car(""));
	}

	@Test
	public void 자동차_이름은_NULL_불가() {
		//given
		//when
		//then
		assertThrows(IllegalArgumentException.class, () -> new Car(null));
	}
}
