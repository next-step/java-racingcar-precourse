package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
	@Test
	void valueTest() {
		assertThatThrownBy(() -> Name.of("Sonata"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThat(Name.of("Tico"))
				.isEqualTo(Name.of("Tico"));
		assertThat(Name.of("Tico"))
				.isNotEqualTo(Name.of("BMW"));
	}
}
