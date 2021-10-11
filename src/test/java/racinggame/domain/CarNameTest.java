package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.message.ErrorMessage;

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

	@ParameterizedTest
	@ValueSource(strings = {"여섯자자동차"})
	@EmptySource
	@NullSource
	void 잘못된_자동차_이름인_경우_EMPTY_CAR_NAME을_메시지로_반환하는지(String carName) {
		try {
			new CarName(carName);
		} catch (IllegalArgumentException | NullPointerException e) {
			assertEquals(ErrorMessage.INVALID_CAR_NAME_INPUT, ErrorMessage.valueOf(e.getMessage()));
		}
	}
}
