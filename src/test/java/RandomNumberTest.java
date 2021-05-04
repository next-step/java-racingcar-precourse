import org.junit.jupiter.api.Test;

import util.RandomUtils;

public class RandomNumberTest {
	private final int RANDOM_TEST_COUNT = 100;

	@Test
	public void 난수_생성_테스트() {
		for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
			testRightRandomNumber(RandomUtils.getRandomNumber());
		}
	}

	private void testRightRandomNumber(int number) {
		if (number < 0 || number > 9) {
			throw new AssertionError("정해진 난수 값이 아닙니다");
		}
	}
}
