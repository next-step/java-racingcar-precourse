package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.message.ErrorMessage;

class CarPositionTest {
	@Test
	void 자동차_전진_시_음수가_들어오면_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			CarPosition carPosition = new CarPosition(0);
			carPosition.increase(-1);
		});
	}

	@Test
	void 자동차_전진_시_9보다_큰_수가_들어오면_IllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			CarPosition carPosition = new CarPosition(0);
			carPosition.increase(10);
		});
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 10})
	void 잘못된_이동거리일_경우_INVALID_CAR_DISTANCE를_메시지로_반환하는지(int distance) {
		CarPosition carPosition = new CarPosition(0);
		try {
			carPosition.increase(distance);
		} catch (IllegalArgumentException e) {
			assertEquals(ErrorMessage.INVALID_CAR_DISTANCE, ErrorMessage.valueOf(e.getMessage()));
		}
	}

	@Test
	void 자동차_전진_시_3_이하의_수가_들어오면_정지() {
		int initialPosition = 0;
		CarPosition carPosition = new CarPosition(initialPosition);
		carPosition.increase(3);
		assertEquals(initialPosition, carPosition.getCarPosition());
	}

	@Test
	void 자동차_전진_시_4_이상의_수가_들어오면_1_만큼_전진() {
		int initialPosition = 0;
		CarPosition carPosition = new CarPosition(initialPosition);
		carPosition.increase(4);
		assertEquals(1, carPosition.getCarPosition() - initialPosition);
	}
}
