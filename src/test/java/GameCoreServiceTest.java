import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class GameCoreServiceTest {

	// 자동차 전진 여부 얻기
	boolean getForwardOrNot() {
		return 4 <= new Random(System.nanoTime()).nextInt(10);
	}

	@Test
	void getForwardOrNotTest() {
		boolean forwardOrNot;
		for (int i = 0; i < 20; i++) {
			forwardOrNot = getForwardOrNot();
			assertThat(forwardOrNot)
				.withFailMessage("전진 아님= " + forwardOrNot)
				.isTrue();
		}
	}

}
