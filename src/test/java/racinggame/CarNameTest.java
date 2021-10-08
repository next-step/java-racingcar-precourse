package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

	@Test
	@DisplayName("자동차 이름이 5글자가 아닐경우 에러")
	void lengthTest() {
		Assertions.assertThatThrownBy(() -> {
			CarName carName = new CarName("123456");
		})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] 자동차 이름은 5글자 이하로 입력해주세요.");
	}
}
