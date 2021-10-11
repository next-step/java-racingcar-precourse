package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CountTest {
	@Test
	void valueTest() {
		assertThatThrownBy(() -> Count.of(0))
				.isInstanceOf(IllegalArgumentException.class);
		assertThat(Count.of(1).getValue())
				.isEqualTo(1);
	}
}
