package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomTest {
	@Test
	void makeRandomValueTest() {
		for (int i = 0; i < 1000000; i++) {
			assertThat(RandomUtils.make()).isLessThan(10);
			assertThat(RandomUtils.make()).isGreaterThanOrEqualTo(0);
		}
	}
}
