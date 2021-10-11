package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RacingGameUtilsTest {
	@Test
	void 랜덩값확인_Test() {
		RacingGameUtils racingGameUtils = new RacingGameUtils();
		assertThat(racingGameUtils.validationRandomNumber(0)).isTrue();
		assertThat(racingGameUtils.validationRandomNumber(9)).isTrue();
		assertThat(racingGameUtils.validationRandomNumber(10)).isFalse();
	}
}
