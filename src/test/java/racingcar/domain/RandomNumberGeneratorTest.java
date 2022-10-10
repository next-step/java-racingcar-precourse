package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@Test
	@DisplayName("0~9 사이의 랜덤 숫자를 생성한다.")
	void generateNumber() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		for (int i = 0; i < 100; i++) {
			int number = randomNumberGenerator.generateNumber();
			Assertions.assertThat(number).isBetween(0, 9);
		}
	}

}