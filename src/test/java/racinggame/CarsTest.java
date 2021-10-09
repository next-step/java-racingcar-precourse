package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

	@ParameterizedTest
	@ValueSource(strings = {"", ",car1,car2,car3", "car1,,car3"})
	@DisplayName("1. 공백을 입력하지 않았는지 "
		+ "2. 맨앞에 쉼표(,)가 있는지 "
		+ "3. 쉼표사이에 공백이 있는지")
	void 자동차_이름_쉼표_공백_검증(String carName) {
		assertThatThrownBy(() -> {
			Cars cars = new Cars(carName);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(Cars.ERROR_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource(value = {"car1,car2,car3:3"}, delimiter = ':')
	void 경주할_자동차_여러개_생성(String carName, int expectedCarNo) {
		Cars cars = new Cars(carName);
		assertThat(cars.getSize()).isEqualTo(expectedCarNo);
	}

	@ParameterizedTest
	@CsvSource(value = {"car1:car1"}, delimiter = ':')
	void 경주할_자동차_1개_생성(String carsName, String expectedCarName) {
		Cars cars = new Cars(carsName);
		assertThat(cars.getSize()).isEqualTo(1);
		assertThat(cars.getCarName(0)).isEqualTo(expectedCarName);
	}
}
