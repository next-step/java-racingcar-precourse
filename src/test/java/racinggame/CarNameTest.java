package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.model.CarName;

public class CarNameTest {

	@ParameterizedTest
	@CsvSource(value = {"p,true", "crong,true", "honuxx,false"})
	void 자동차_이름은_5자_이하(String name, boolean isValid) {
		CarName carName = new CarName(name);

		assertThat(carName.isValid()).isEqualTo(isValid);
	}

	@ParameterizedTest
	@CsvSource(value = {"p", "crong", "honuxx"})
	void 자동차이름_생성_테스트(String name) {
		CarName carName = new CarName(name);

		assertThat(carName.getName()).isEqualTo(name);
	}
}
