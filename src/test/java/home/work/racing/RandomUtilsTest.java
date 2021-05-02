package home.work.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

	@Test
	final void testRandom() {
		for (int i = 0; i < 10000; i++) {
			assertThat(RandomUtils.random())
				.extracting("num")
				.asInstanceOf(InstanceOfAssertFactories.INTEGER)
				.isBetween(1, 9);
		}
	}

}