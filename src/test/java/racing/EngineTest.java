package racing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class EngineTest {
	private Engine engine;

	@BeforeEach
	void init() {
		this.engine = new Engine();
	}

	@DisplayName("숫자 0 에서 9 사이의 random 값을 구한다.")
	@RepeatedTest(100)
	void 숫자_0_9_사이의_random_값을_구한다() {
		int power = this.engine.getPower();

		assertTrue(isBetween(power, 0, 9));
	}

	@DisplayName("숫자가 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.")
	@Test
	void 숫자가_4_이상일_경우_전진하고_3_이하의_값이면_멈춘다() {
		assertEquals(CarStatus.STOP, this.engine.run(0));
		assertEquals(CarStatus.STOP, this.engine.run(3));
		assertEquals(CarStatus.FORWARD, this.engine.run(4));
		assertEquals(CarStatus.FORWARD, this.engine.run(9));
	}

	private boolean isBetween(int val, int start, int end) {
		return start <= val && val <= end;
	}
}
