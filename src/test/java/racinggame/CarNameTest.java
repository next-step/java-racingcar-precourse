package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

	@Test
	@DisplayName("자동차 이름이 5글자가 아닐경우 에러")
	void lengthTest() {
		assertThatThrownBy(() -> {
			CarName carName = new CarName("123456");
		})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CarName.ERROR_MESSAGE);
	}
}
