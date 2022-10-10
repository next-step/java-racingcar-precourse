package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberGeneratorTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4})
	@DisplayName("숫자 생성 테스트")
	void numberGeneratorTest(int input) {
		NumberGenerator numberGenerator = () -> input;
		assertEquals(input, numberGenerator.generateNumber());
	}

}