import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class GameCoreServiceTest {

	// 0~9사이의 무작위 숫자 생성
	int createRandomNumber() {
		return new Random(System.nanoTime()).nextInt(10);
	}

	@Test
	void isValidRandomValue() {
		int randomValue;
		for (int i = 0; i < 10000; i++) {
			randomValue = createRandomNumber();
			assertThat(randomValue)
				.withFailMessage("0~9의 숫자가 아님= " + randomValue)
				.isBetween(0, 9);
		}
	}

}
