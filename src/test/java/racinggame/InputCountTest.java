package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import org.junit.jupiter.api.Test;

import racinggame.domain.InputCount;

public class InputCountTest {

	@Test
	void 더하기() {
		InputCount inputCount = new InputCount();
		inputCount.plus();
		int result = inputCount.getCount();

		assertThat(result).isEqualTo(2);
	}

	// @Test
	// void 더하기_가능여부_확인() {
	// 	InputCount inputCount = new InputCount();
	// 	for (int i = 1; i < MAX_INPUT_COUNT; i++) {
	// 		inputCount.plus();
	// 		assertThat(inputCount.isPossible()).isTrue();
	// 	}
	// }

	@Test
	void 더하기_가능여부_예외() {
		InputCount inputCount = new InputCount();
		for (int i = 1; i < MAX_INPUT_COUNT; i++) {
			inputCount.plus();
		}

		assertThatThrownBy(inputCount::plus)
			.isInstanceOf(IllegalStateException.class)
			.hasMessage(ERROR_TO_MANY_INPUT);
	}
}
