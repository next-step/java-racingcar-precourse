package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	@DisplayName("start 메서드실행시 결과메세지 포멧과 같은 메세지를 가지고 있는지 테스트")
	@Test
	void start() {
		RacingGame racingGame = new RacingGame(Arrays.asList("tom", "dick", "harry"));
		assertThat(racingGame.start(5).getRaceResult()).contains("실행 결과", "최종 우승자는");
	}
}