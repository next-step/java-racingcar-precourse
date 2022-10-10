package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

	@DisplayName("자동차 경주 - 결과 반환")
	@Test
	void play() {
		CarNameList carNameList = CarNameList.from("abc,def");
		RoundCount roundCount = RoundCount.from("3");
		GameResult gameResult = new RacingCarGame(carNameList, roundCount).play();
		assertThat(gameResult).isNotNull();
		assertThat(gameResult.getRoundResult()).isNotNull();
		assertThat(gameResult.getRoundResult().getRoundList()).hasSize(3);
	}
}