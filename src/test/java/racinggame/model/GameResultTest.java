package racinggame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

	@Test
	void 결과_입력_검증() {
		GameResult gameResult = new GameResult();
		gameResult.addResult(Arrays.asList("결과1", "결과2"));
		assertThat(gameResult.getResultList().size()).isEqualTo(2);
	}
}
