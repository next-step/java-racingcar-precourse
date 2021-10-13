package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import racinggame.model.CarName;

public class CarNameTest {

	@Test
	void 자동차_이름_5자_이상() {
		Throwable thrown = catchThrowable(() -> {
			new CarName("123456");
		});

		assertThat(thrown)
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 자동차_이름_없을_경우() {
		Throwable thrown = catchThrowable(() -> {
			new CarName("");
		});

		assertThat(thrown)
			.isInstanceOf(NoSuchElementException.class);
	}

}
