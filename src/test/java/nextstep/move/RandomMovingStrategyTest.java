package nextstep.move;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMovingStrategyTest {

	@DisplayName("싱글턴 테스트")
	@Test
	void singleton() {
		// given: none

		// when then
		assertSame(RandomMovingStrategy.getInstance(), RandomMovingStrategy.getInstance());
	}
}