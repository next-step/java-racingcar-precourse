package nextstep.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomsTest {

	@DisplayName("랜덤 숫자의 범위를 0-0 로 하는경우, 0만 생성되는지 (범위) 테스트")
	@Test
	void pickNumberInRange() {
		// given: none

		// when then
		assertEquals(0, Randoms.pickNumberInRange(0, 0));
	}
}