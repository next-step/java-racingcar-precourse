package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.InvalidNumberException;

class LabsTest {

	@DisplayName("입력 성공")
	@ParameterizedTest
	@ValueSource(ints = {1, 10, 100, 100000, Integer.MAX_VALUE})
	void 성공(int value) {
		assertThatNoException().isThrownBy(() -> new Lap(String.valueOf(value)));
	}

	@DisplayName("에러발생 - 문자 입력")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "123abc", "1gd4"})
	void 문자_입력(String value) {
		assertThatThrownBy(() -> new Lap(value))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage("[ERROR] 1 이상 자연수를 입력하세요.");
	}

	@DisplayName("에러발생 - 0, 음수 입력")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "-100", "0"})
	void 음수_0_입력(String value) {
		assertThatThrownBy(() -> new Lap(value))
			.isInstanceOf(InvalidNumberException.class)
			.hasMessage("[ERROR] 1 이상 자연수를 입력하세요.");
	}

}