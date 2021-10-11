package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {
	@Test
	void lengthTest() {
		assertThatThrownBy(() -> Distance.of(-1))
				.isInstanceOf(IllegalArgumentException.class);
		assertThat(Distance.of(0).getLength())
				.isEqualTo(0);
		assertThat(Distance.of(1).getLength())
				.isEqualTo(1);
	}
}
