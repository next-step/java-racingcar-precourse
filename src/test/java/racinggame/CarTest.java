package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 자동차들의_이름의_길이가_5이상이면_안된다() {
		assertThatThrownBy(() -> new Car("carAAA"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5자 이하여야 합니다");
	}
}
