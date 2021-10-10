package racinggame.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.boxing.CarName;
import racinggame.error.CarNameLengthException;
import racinggame.error.EmptyCarException;
import racinggame.error.ErrorMessage;

public class CarTest {

	@DisplayName("자동차 이름 Test - 이름 길이")
	@Test
	void carNameLengthTest() {
		assertThatThrownBy(() -> new CarName("123456"))
			.isInstanceOf(CarNameLengthException.class)
			.hasMessageContaining(ErrorMessage.CARNAME_IS_TOO_LONG);
	}

	@DisplayName("자동차 이름 Test - Empty")
	@Test
	void carNameInvalidTest() {
		assertThatThrownBy(() -> new CarName(""))
			.isInstanceOf(EmptyCarException.class)
			.hasMessageContaining(ErrorMessage.CARNAME_IS_EMPTY);
	}

	@DisplayName("자동차 생성 Test")
	@Test
	void carGenerateTest() {
		CarName carName = new CarName("자동차");
		assertThat(new Car(carName)).isNotNull();
	}
}
