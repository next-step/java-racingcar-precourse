package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

	@ParameterizedTest
	@ValueSource(strings = {"틀린이름입니다", "123424", ""})
	void 자동차이름_예외처리_테스트(String testData) {
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Name(testData));
	}
}