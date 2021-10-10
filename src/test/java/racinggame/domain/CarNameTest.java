package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {
	@Test
	void 자동차_이름이_5자보다_많으면_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName("여섯자자동차");
		});
	}

	@Test
	void 자동차_이름이_1자보다_적으면_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName("");
		});
	}

	@Test
	void 자동차_이름이_null이면_NullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new CarName(null);
		});
	}
}
