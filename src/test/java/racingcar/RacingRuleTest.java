package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingRuleTest {

	@Test
	@DisplayName("차에 랜덤값을 전달하여 이동 여부 테스트")
	void isMoveTest() {
		assertThat(RacingRule.isMovable(3)).isFalse();
		assertThat(RacingRule.isMovable(4)).isTrue();
	}
}
