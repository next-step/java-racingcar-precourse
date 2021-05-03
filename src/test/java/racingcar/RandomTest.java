package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomTest {
	@Test
	void makeRandomValueTest() {
		assertThat(RandomUtils.make()).isLessThan(10);
		assertThat(RandomUtils.make()).isGreaterThan(0);
	}
}
