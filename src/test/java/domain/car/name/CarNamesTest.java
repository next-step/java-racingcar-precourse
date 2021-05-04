package domain.car.name;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

	@Test
	@DisplayName("CarNames 생성")
	void carNames() {
		String names = "test,pobi,1234";

		CarNames carNames = new CarNames(names);

		assertThat(carNames).isNotNull();
		assertThat(carNames.getNames())
			.contains(CarName.of("test"), CarName.of("pobi"));

	}
}
