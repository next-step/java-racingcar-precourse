package nextstep.generator;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@DisplayName("싱글턴 테스트")
	@Test
	void getInstance() {
		// given: none

		// when then
		assertSame(RandomNumberGenerator.getInstance(), RandomNumberGenerator.getInstance());
	}

	@DisplayName("0~9 사이의 범위의 숫자만 생성하는지 테스트")
	@Test
	void generate() {
		// given
		final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();

		// when then
		for (int i = 0; i < 1000; i++) {
			final int generate = randomNumberGenerator.generate();
			assertTrue(0 <= generate && generate <= 9);
		}
	}
}