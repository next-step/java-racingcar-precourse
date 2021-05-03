package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	public void 입력_값이_0에서_3_사이의_값이면_자동차_정지(int condition) {
		//given
		Car car = new Car("car");

		//when
		int distance = car.move(condition);

		//then
		Assertions.assertThat(distance).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void 입력_값이_4에서_9_사이의_값이면_자동차_전진(int condition) {
		//given
		Car car = new Car("car");

		//when
		int distance = car.move(condition);

		//then
		Assertions.assertThat(distance).isEqualTo(1);
	}

}
