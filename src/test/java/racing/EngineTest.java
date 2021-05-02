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

	@DisplayName("엔진에서 0 에서 9 사이의 임의의 출력을 구한다.")
	@RepeatedTest(10)
	void 엔진에서_0_9_사이의_임의의_출력을_구한다() {
		Power power = this.engine.getPower();

		assertTrue(isBetween(power.getVal(), 0, 9));
	}

	@DisplayName("출력이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.")
	@Test
	void 출력이_4_이상일_경우_전진하고_3_이하의_값이면_멈춘다() {
		assertEquals(CarStatus.STOP, this.engine.run(new Power(0)));
		assertEquals(CarStatus.STOP, this.engine.run(new Power(3)));
		assertEquals(CarStatus.FORWARD, this.engine.run(new Power(4)));
		assertEquals(CarStatus.FORWARD, this.engine.run(new Power(9)));
	}

	private boolean isBetween(int val, int start, int end) {
		return start <= val && val <= end;
	}
}
