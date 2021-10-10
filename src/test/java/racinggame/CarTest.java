package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
	@ParameterizedTest
	@CsvSource(value = {"p,true", "crong,true", "honuxx,false"})
	void 유효한_자동차인지_확인(String name, boolean isValid) {
		CarName carName = new CarName(name);
		CarDistance carDistance = new CarDistance(0);
		Car car = new Car(carName, carDistance);

		assertThat(car.isValid()).isEqualTo(isValid);
	}
}
