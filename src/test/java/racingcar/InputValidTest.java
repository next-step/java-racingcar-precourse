package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.InputValidation;

public class InputValidTest {
	@Test
	void carNameValidTest() {
		assertThat(InputValidation.parseInputValueCar("pobi,woni,jun")).isTrue();
		assertThatThrownBy(() -> InputValidation.parseInputValueCar("waaaaaa,fasdf"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void numberTypeValidTest() {
		assertThat(InputValidation.intValueChecking("1")).isEqualTo(1);
		assertThatThrownBy(() -> InputValidation.intValueChecking("gfef"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
