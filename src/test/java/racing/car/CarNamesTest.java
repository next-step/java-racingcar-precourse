package racing.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

	@DisplayName("자동차의 이름은 쉼표(,)를 기준으로 구분한다.")
	@Test
	void 자동차의_이름은_쉼표를_기준으로_구분한다() {
		CarNames carNames = new CarNames("pobi,crong,honux");
		List<CarName> actual = carNames.getNames();
		List<CarName> expected = Arrays.asList(
			new CarName("pobi"),
			new CarName("crong"),
			new CarName("honux"));

		assertEquals(expected, actual);
	}
}
