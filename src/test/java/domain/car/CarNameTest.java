package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

	@Test
	@DisplayName("자동차 이름은 5글자 이하만 됩니다 (성공)")
	void carNameCreateSuccess() {
		String name = "abcde";

		CarName carName = CarName.of(name);

		assertThat(carName).isNotNull();
	}

	@Test
	@DisplayName("자동차 이름은 5글자 이하만 됩니다 (실패)")
	void carNameCreateFail() {
		String name = "abcdef";
		String errorMessage = "자동차 이름은 5글자 이하만 됩니다.";

		assertThatIllegalArgumentException()
			.isThrownBy(() -> CarName.of(name))
			.withMessage(errorMessage)
		;
	}
}
