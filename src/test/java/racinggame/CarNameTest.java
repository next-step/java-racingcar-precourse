package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

import racinggame.model.CarName;

public class CarNameTest {
	@Test
	void 자동차_이름_오류() {
		Throwable thrown = catchThrowable(() -> {
			new CarName("123456");
		});

		assertThat(thrown)
			.isInstanceOf(IllegalArgumentException.class);
	}
}
