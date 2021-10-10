package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

	@Test
	void 자동차_전진_시_3_이하의_수가_들어오면_정지() {
		int initialPosition = 0;
		CarPosition carPosition = new CarPosition(initialPosition);
		carPosition.increase(3);
		assertEquals(initialPosition, carPosition.getCarPosition());
	}

	@Test
	void 자동차_전진_시_4_이상의_수가_들어오면_그_수_만큼_전진() {
		int initialPosition = 0;
		CarPosition carPosition = new CarPosition(initialPosition);
		carPosition.increase(4);
		assertEquals(initialPosition + 4, carPosition.getCarPosition());
	}
}
