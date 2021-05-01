package racing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

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

	private boolean isBetween(int val, int start, int end) {
		return start <= val && val <= end;
	}
}
