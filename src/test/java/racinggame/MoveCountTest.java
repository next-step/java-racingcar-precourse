package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCountTest {

	@ParameterizedTest
	@ValueSource(strings = {"29'el,", "code", "-1", "0"})
	void 이동횟수_예외처리_테스트(String testData) {
		Assertions.assertThatIllegalArgumentException().isThrownBy(() -> MoveCount.get(testData));
	}

	@Test
	void 이동횟수_값_얻기_테스트() {
		MoveCount moveCount = MoveCount.get("1");
		Assertions.assertThat(moveCount.value()).isEqualTo(1);
	}
}
