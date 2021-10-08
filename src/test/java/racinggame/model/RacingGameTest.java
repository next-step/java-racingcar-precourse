package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	@Test
	@DisplayName("자동차게임을 생성한다.")
	public void createRacingGame() {
		RacingGame racingGame = new RacingGame(new Cars("aa,bb,cc"), new TryCount(2));

		assertThat(racingGame).isEqualTo(new RacingGame(new Cars("aa,bb,cc"), new TryCount(2)));
	}

	@Test
	@DisplayName("게임 레이싱 종료를 알 수 있다.")
	public void isFinish() {
		RacingGame racingGame = new RacingGame(new Cars("aa,bb,cc"), new TryCount(2));

		racingGame.racing();
		Assertions.assertAll(
			() -> assertThat(racingGame.isNotFinish()).isTrue(),
			() -> {
				racingGame.racing();
				assertThat(racingGame.isNotFinish()).isFalse();
			}
		);
	}

}