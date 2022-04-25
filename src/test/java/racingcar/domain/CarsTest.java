package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.dto.GameResult;

public class CarsTest {
	private final String car1 = "자동차1";
	private final String car2 = "자동차2";
	private final String car3 = "자동차3";

	@Test
	@DisplayName("우승자 확인")
	void add() {
		// given
		Cars cars = new Cars(Arrays.asList(
			new Car(car1, 2),
			new Car(car2, 3),
			new Car(car3, 3)));

		// when
		GameResult result = cars.getWinners();

		// then
		assertThat(result.getNames()).contains(car2, car3);
	}
}
